import java.sql.*;
import java.util.Scanner;

/**
 * Console app for Student Management (CRUD using JDBC)
 */
public class StudentApp {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            printMenu();
            System.out.print("Enter choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1": addStudent(); break;
                case "2": viewStudents(); break;
                case "3": updateStudent(); break;
                case "4": deleteStudent(); break;
                case "0": System.out.println("Exiting..."); return;
                default: System.out.println("Invalid choice.\n");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n===== Student Management System =====");
        System.out.println("1. Add New Student");
        System.out.println("2. View All Students");
        System.out.println("3. Update Student by ID");
        System.out.println("4. Delete Student by ID");
        System.out.println("0. Exit");
    }

    private static void addStudent() {
        try (Connection conn = DBConnection.getConnection()) {
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Email: ");
            String email = scanner.nextLine();
            System.out.print("Age: ");
            int age = Integer.parseInt(scanner.nextLine());

            String sql = "INSERT INTO students (name, email, age) VALUES (?, ?, ?)";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, name);
                ps.setString(2, email);
                ps.setInt(3, age);
                ps.executeUpdate();
                System.out.println("✅ Student added successfully.");
            }
        } catch (Exception e) {
            System.err.println("Error adding student: " + e.getMessage());
        }
    }

    private static void viewStudents() {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM students");
             ResultSet rs = ps.executeQuery()) {

            System.out.println("\n--- Student List ---");
            while (rs.next()) {
                Student s = new Student(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getInt("age")
                );
                System.out.println(s);
            }
        } catch (Exception e) {
            System.err.println("Error fetching students: " + e.getMessage());
        }
    }

    private static void updateStudent() {
        try (Connection conn = DBConnection.getConnection()) {
            System.out.print("Enter student ID to update: ");
            int id = Integer.parseInt(scanner.nextLine());

            System.out.print("New Name: ");
            String name = scanner.nextLine();
            System.out.print("New Email: ");
            String email = scanner.nextLine();
            System.out.print("New Age: ");
            int age = Integer.parseInt(scanner.nextLine());

            String sql = "UPDATE students SET name=?, email=?, age=? WHERE id=?";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, name);
                ps.setString(2, email);
                ps.setInt(3, age);
                ps.setInt(4, id);

                int rows = ps.executeUpdate();
                if (rows > 0) {
                    System.out.println("✅ Student updated successfully.");
                } else {
                    System.out.println("⚠️ Student not found.");
                }
            }
        } catch (Exception e) {
            System.err.println("Error updating student: " + e.getMessage());
        }
    }

    private static void deleteStudent() {
        try (Connection conn = DBConnection.getConnection()) {
            System.out.print("Enter student ID to delete: ");
            int id = Integer.parseInt(scanner.nextLine());

            String sql = "DELETE FROM students WHERE id=?";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setInt(1, id);
                int rows = ps.executeUpdate();
                if (rows > 0) {
                    System.out.println("✅ Student deleted successfully.");
                } else {
                    System.out.println("⚠️ Student not found.");
                }
            }
        } catch (Exception e) {
            System.err.println("Error deleting student: " + e.getMessage());
        }
    }
}
