package application;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Example {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/tree";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "N@$2005";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            if (connection != null) {
                System.out.println("Connected to the database!");

                // Create operation
                createRecord(connection, "John", 25);

                // Read operation
                readRecords(connection);

                // Update operation
                updateRecord(connection, 1, "Updated Name", 30);

                // Read operation after update
                readRecords(connection);

                // Delete operation
                deleteRecord(connection, 1);

                // Read operation after delete
                readRecords(connection);
            } else {
                System.out.println("Failed to make connection!");
            }
        } catch (SQLException e) {
            System.err.println("Error connecting to the database: " + e.getMessage());
        }
    }

    private static void createRecord(Connection connection, String name, int age) throws SQLException {
        String sql = "INSERT INTO users (name, age) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, name);
            statement.setInt(2, age);
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new record has been inserted successfully.");
            }
        }
    }

    private static void readRecords(Connection connection) throws SQLException {
        String sql = "SELECT * FROM users";
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age);
            }
        }
    }

    private static void updateRecord(Connection connection, int id, String name, int age) throws SQLException {
        String sql = "UPDATE users SET name=?, age=? WHERE id=?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, name);
            statement.setInt(2, age);
            statement.setInt(3, id);
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Record updated successfully.");
            } else {
                System.out.println("No record found with the given ID.");
            }
        }
    }

    private static void deleteRecord(Connection connection, int id) throws SQLException {
        String sql = "DELETE FROM users WHERE id=?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Record deleted successfully.");
            } else {
                System.out.println("No record found with the given ID.");
            }
        }
    }
}
