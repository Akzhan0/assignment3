package oop;

public class SeriesItem extends BaseEntity {
    private int episodes;

    public SeriesItem(int id, String name, int episodes) {
        super(id, name);
        this.episodes = episodes;
    }

    @Override
    public void validate() {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("Series name empty");
        if (episodes <= 0) throw new IllegalArgumentException("Episodes must be > 0");
    }

    @Override
    public String getType() {
        return "SERIES";
    }

    @Override
    public double getScore() {
        return episodes * 2.0;
    }
}

