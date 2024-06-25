import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.List;

/**
 * Represents a customer renting movies.
 */
public class Customer {
    private final String name;
    private final List<MovieRental> rentals;

    /**
     * Initializes a new instance of Customer.
     * @param name name of the customer
     * @param rentals list of movies rented by this customer
     */
    public Customer(String name, List<MovieRental> rentals) {
        this.name = name;
        this.rentals = rentals;
    }

    /**
     * Returns the name of this customer.
     */
    public String getName() {
        return name;
    }

    /**
     * Compiles a rental statement for this customer and writes it to a supplied {@link Writer}.
     * @param writer where the statement will be written to
     * @throws IOException if IO error occurs
     */
    public void printStatement(Writer writer) throws IOException{
        writer.write(String.format("Rental Record for %s", name));
        writer.write("\n");

        var total = 0.0;
        var freqPts = 0;

        for(var rental : rentals){
            var thisAmount = rental.computeRate();
            total += thisAmount;
            freqPts += 1 + rental.computeBonusPoints();

            writer.write("\t");
            writer.write(rental.movieTitle());
            writer.write("\t");
            writer.write(String.format("%.1f", thisAmount));
            writer.write("\n");
        }

        writer.write(String.format("Amount owed is %.1f", total));
        writer.write("\n");
        writer.write(String.format("You earned %d frequent points", freqPts));
        writer.write("\n");
        
        writer.flush();
    }

    public String printStatement() throws IOException {
        var sw = new StringWriter();
        printStatement(sw);
        return sw.toString();
    }
}
