/**
 * Represents a children's movie.
 */
public class ChildrenMovie extends AbstractMovie {

    ChildrenMovie(String id, String title) {
        super(id, title);
    }

    @Override
    public double rate(int nDays) {
        var rate = 1.5;
        if(nDays > 3) {
            rate += (nDays - 3) * 1.5;
        }
        return rate;
    }

    @Override
    public int bonusPoints(int nDays) {
        return 0;
    }
    
}
