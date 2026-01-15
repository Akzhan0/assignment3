package oop;

import java.util.ArrayList;
import java.util.List;

public class Playlist implements Validatable {
    private String title;
    private final List<BaseEntity> items = new ArrayList<>();

    public Playlist(String title) {
        this.title = title;
    }

    public void add(BaseEntity item) {
        items.add(item);
    }

    public List<BaseEntity> getItems() {
        return items;
    }

    @Override
    public void validate() {
        if (title == null || title.isBlank()) throw new IllegalArgumentException("Playlist title empty");
        if (items.isEmpty()) throw new IllegalArgumentException("Playlist must have at least 1 item");
    }
}
