/**
 * Represents a rentable movie. Implementations will contain specific rules for rate and bonus point calculation.
 */
public interface Movie {

    /**
     * Returns a title of this movie. movie
     */
    String title();

    /**
     * Returns a unique identifier of this movie.
     */
    String id();

    /**
     * Computes a rate for renting this movie during a specific number of days.
     * @param nDays number of days that this movie is rented
     * @return rental rate
     */
    double rate(int nDays);

    /**
     * Computes bonus points for renting this movie during a specific number of days.
     * @param nDays number of days that this movie is rented
     * @return number of bonus points
     */
    int bonusPoints(int nDays);
}
