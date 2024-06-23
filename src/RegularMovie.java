/**
 * Represents a regular movie.
 */
public class RegularMovie extends AbstractMovie {

    RegularMovie(String id, String title) {
        super(id, title);
    }

    @Override
    public double rate(int nDays) {
        var rate = 2.0;
        if(nDays > 2) {
            rate += (nDays - 2) * 1.5;
        }
        return rate;
    }

    @Override
    public int bonusPoints(int nDays) {
        return 0;
    }
    
}
