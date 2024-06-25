import java.util.Objects;

/**
 * Represents a movie rental over a specific number of days.
 */
public class MovieRental {
    private final Movie movie;
    private final int days;
    
    /**
     * Initializes a new instance of {@link MovieRental}.
     * @param movie movie that is being rented
     * @param days how long the movie is being rented
     */
    public MovieRental(Movie movie, int days) {
        this.movie = Objects.requireNonNull(movie, "Movie instance must not be null");
        this.days = days;
    }

    /**
     * Returns the title of the rented movie.
     */
    public String movieTitle(){
        return movie.title();
    }

    /**
     * Returns a rate to be charged for this movie rental.
     */
    public double computeRate(){
        return movie.rate(days);
    }

    /**
     * Returns bonus points awarded for this movie rental.
     */
    public int computeBonusPoints(){
        return movie.bonusPoints(days);
    }
}
