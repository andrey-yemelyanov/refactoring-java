abstract class AbstractMovie implements Movie {
    protected final String id;
    protected final String title;

    AbstractMovie(String id, String title){
        this.id = id;
        this.title = title;
    }

    @Override
    public String title() {
        return title;
    }

    @Override
    public String id() {
        return id;
    }
}
