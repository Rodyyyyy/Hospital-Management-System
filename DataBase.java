package com.example;
import java.sql.*;
public class DataBase {
    private static final String DB_URL = "jdbc:sqlite:B:/colleage/coding/data project/demo/src/main/java/com/example/db.db";
    public static Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL);
            System.out.println("Connected to the SQLite database.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    public static LinkedList<Patient> getAllPatients() {
        LinkedList<Patient> patients = new LinkedList<Patient>();
        String sql = "SELECT * FROM patients";

        try (Connection conn = connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                
                Patient patient = new Patient(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("contact_info"),
                        rs.getString("medical_history"));
                
                patients.insertLast(new Node<Patient>(patient));
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving patients: " + e.getMessage());
        }
        return patients;
    }
    
}

