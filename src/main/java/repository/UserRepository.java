package repository;

import exception.DatabaseOperationException;
import model.User;
import utils.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    public void create(User user) {
        String sql = "INSERT INTO users(name, surname, gender) VALUES (?, ?, ?)";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, user.getName());
            ps.setString(2, user.getSurname());
            ps.setString(3, user.getGender());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new DatabaseOperationException("DB create user failed", e);
        }
    }

    public List<User> getAll() {
        String sql = "SELECT id, name, surname, gender FROM users ORDER BY id";
        List<User> users = new ArrayList<>();

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                users.add(new User(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getString("gender")
                ));
            }
            return users;

        } catch (SQLException e) {
            throw new DatabaseOperationException("DB getAll users failed", e);
        }
    }

    public User getById(int id) {
        String sql = "SELECT id, name, surname, gender FROM users WHERE id = ?";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new User(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("surname"),
                            rs.getString("gender")
                    );
                }
                return null;
            }

        } catch (SQLException e) {
            throw new DatabaseOperationException("DB getById user failed", e);
        }
    }

    public boolean existsByNameSurname(String name, String surname) {
        String sql = "SELECT 1 FROM users WHERE name = ? AND surname = ? LIMIT 1";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, name);
            ps.setString(2, surname);

            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }

        } catch (SQLException e) {
            throw new DatabaseOperationException("DB exists check failed", e);
        }
    }

    public boolean update(int id, User user) {
        String sql = "UPDATE users SET name = ?, surname = ?, gender = ? WHERE id = ?";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, user.getName());
            ps.setString(2, user.getSurname());
            ps.setString(3, user.getGender());
            ps.setInt(4, id);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new DatabaseOperationException("DB update user failed", e);
        }
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM users WHERE id = ?";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new DatabaseOperationException("DB delete user failed", e);
        }
    }
}

