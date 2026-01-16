import exception.DuplicateResourceException;
import exception.InvalidInputException;
import exception.ResourceNotFoundException;
import model.User;
import service.UserService;

import oop.BaseEntity;
import oop.MovieItem;
import oop.Playlist;
import oop.SeriesItem;

public class Main {

    public static void main(String[] args) {

        UserService service = new UserService();

        try {
            service.createUser(new User("", "Test", "M"));
        } catch (InvalidInputException e) {
            System.out.println("VALIDATION ERROR: " + e.getMessage());
        }

        try {
            service.createUser(new User("Aruzhan", "Saparova", "F"));
            System.out.println("CREATED: Aruzhan Saparova");
        } catch (DuplicateResourceException e) {
            System.out.println("DUPLICATE ERROR: " + e.getMessage());
        }

        try {
            service.createUser(new User("Aruzhan", "Saparova", "F"));
        } catch (DuplicateResourceException e) {
            System.out.println("DUPLICATE ERROR: " + e.getMessage());
        }

        System.out.println("=== USERS ===");
        service.getAllUsers().forEach(System.out::println);

        try {
            service.getUserById(9999);
        } catch (ResourceNotFoundException e) {
            System.out.println("NOT FOUND: " + e.getMessage());
        }

        try {
            Playlist playlist = new Playlist("My Watchlist");

            BaseEntity movie = new MovieItem(1, "Interstellar", 169);
            BaseEntity series = new SeriesItem(2, "Sherlock", 12);

            movie.validate();
            series.validate();

            playlist.add(movie);
            playlist.add(series);
            playlist.validate();

            System.out.println("\n=== OOP DEMO ===");
            for (BaseEntity item : playlist.getItems()) { // polymorphism
                item.printInfo();                         // concrete method
                System.out.println(
                        "Type=" + item.getType() +
                                ", score=" + item.getScore()
                );
            }

        } catch (Exception e) {
            System.out.println("OOP DEMO ERROR: " + e.getMessage());
        }

        System.out.println("\nPROGRAM FINISHED");
    }
}


