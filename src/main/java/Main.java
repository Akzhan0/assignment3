import exception.DuplicateResourceException;
import exception.InvalidInputException;
import exception.ResourceNotFoundException;
import model.User;
import service.UserService;

// OOP imports
import oop.BaseEntity;
import oop.MovieItem;
import oop.Playlist;
import oop.SeriesItem;

public class Main {

    public static void main(String[] args) {

        // ===== DATABASE + SERVICE DEMO =====
        UserService service = new UserService();

        // 1) VALIDATION error
        try {
            service.createUser(new User("", "Test", "M"));
        } catch (InvalidInputException e) {
            System.out.println("VALIDATION ERROR: " + e.getMessage());
        }

        // 2) CREATE user (ok or duplicate)
        try {
            service.createUser(new User("Aruzhan", "Saparova", "F"));
            System.out.println("CREATED: Aruzhan Saparova");
        } catch (DuplicateResourceException e) {
            System.out.println("DUPLICATE ERROR: " + e.getMessage());
        }

        // 3) DUPLICATE demo
        try {
            service.createUser(new User("Aruzhan", "Saparova", "F"));
        } catch (DuplicateResourceException e) {
            System.out.println("DUPLICATE ERROR: " + e.getMessage());
        }

        // 4) READ ALL
        System.out.println("=== USERS ===");
        service.getAllUsers().forEach(System.out::println);

        // 5) NOT FOUND demo
        try {
            service.getUserById(9999);
        } catch (ResourceNotFoundException e) {
            System.out.println("NOT FOUND: " + e.getMessage());
        }

        // ===== OOP DEMO (ABSTRACT + INTERFACES + POLYMORPHISM + COMPOSITION) =====
        try {
            Playlist playlist = new Playlist("My Watchlist");

            BaseEntity movie = new MovieItem(1, "Interstellar", 169);
            BaseEntity series = new SeriesItem(2, "Sherlock", 12);

            // interface method (Validatable)
            movie.validate();
            series.validate();

            // composition
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

        System.out.println("\nPROGRAM FINISHED ✅");
    }
}


