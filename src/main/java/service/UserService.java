package service;

import exception.DuplicateResourceException;
import exception.InvalidInputException;
import exception.ResourceNotFoundException;
import model.User;
import repository.UserRepository;

import java.util.List;

public class UserService {

    // ✅ вот это и есть repo (у тебя его не было)
    private final UserRepository repo = new UserRepository();

    public void createUser(User user) {
        validateUser(user);

        if (repo.existsByNameSurname(user.getName(), user.getSurname())) {
            throw new DuplicateResourceException(
                    "User already exists: " + user.getName() + " " + user.getSurname()
            );
        }

        repo.create(user);
    }

    public List<User> getAllUsers() {
        return repo.getAll();
    }

    public User getUserById(int id) {
        if (id <= 0) {
            throw new InvalidInputException("id must be > 0");
        }

        User user = repo.getById(id);
        if (user == null) {
            throw new ResourceNotFoundException("User not found with id=" + id);
        }

        return user;
    }

    public void updateUser(int id, User user) {
        if (id <= 0) {
            throw new InvalidInputException("id must be > 0");
        }
        validateUser(user);

        boolean ok = repo.update(id, user);
        if (!ok) {
            throw new ResourceNotFoundException("User not found with id=" + id);
        }
    }

    public void deleteUser(int id) {
        if (id <= 0) {
            throw new InvalidInputException("id must be > 0");
        }

        boolean ok = repo.delete(id);
        if (!ok) {
            throw new ResourceNotFoundException("User not found with id=" + id);
        }
    }

    private void validateUser(User user) {
        if (user == null) throw new InvalidInputException("User is null");

        if (user.getName() == null || user.getName().isBlank())
            throw new InvalidInputException("Name cannot be empty");

        if (user.getSurname() == null || user.getSurname().isBlank())
            throw new InvalidInputException("Surname cannot be empty");

        if (user.getGender() == null || user.getGender().isBlank())
            throw new InvalidInputException("Gender cannot be empty");
    }
}


