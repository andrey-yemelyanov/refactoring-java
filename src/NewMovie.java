/**
 * Represents a new movie.
 */
public class NewMovie extends AbstractMovie {

    NewMovie(String id, String title) {
        super(id, title);
    }

    @Override
    public double rate(int nDays) {
        return nDays * 3;
    }

    @Override
    public int bonusPoints(int nDays) {
        if(nDays > 2) {
            return 1;
        }
        return 0;
    }
    
}
