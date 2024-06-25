import java.io.IOException;
import java.util.List;

public class Main {

  public static void main(String[] args) throws IOException {
    final String expected = "Rental Record for C. U. Stomer\n\tYou've Got Mail\t3.5\n\tMatrix\t2.0\nAmount owed is 5.5\nYou earned 2 frequent points\n";

    var customer = new Customer("C. U. Stomer", 
      List.of(
        new MovieRental(new RegularMovie("F001", "You've Got Mail"), 3),
        new MovieRental(new RegularMovie("F002", "Matrix"), 1)));

    var actual = customer.printStatement();

    if (!actual.equals(expected)) {
      throw new AssertionError("Expected: " + System.lineSeparator() + String.format(expected) + System.lineSeparator() + System.lineSeparator() + "Got: " + System.lineSeparator() + actual);
    }

    System.out.println("Success");
  }
}
