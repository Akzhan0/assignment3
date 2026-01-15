package oop;

public class MovieItem extends BaseEntity {
    private int durationMinutes;

    public MovieItem(int id, String name, int durationMinutes) {
        super(id, name);
        this.durationMinutes = durationMinutes;
    }

    @Override
    public void validate() {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("Movie name empty");
        if (durationMinutes <= 0) throw new IllegalArgumentException("Duration must be > 0");
    }

    @Override
    public String getType() {
        return "MOVIE";
    }

    @Override
    public double getScore() {
        return durationMinutes / 10.0;
    }
}
