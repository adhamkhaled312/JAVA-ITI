package iti.jdbc;

import java.sql.*;

public class App {

    static String url = "jdbc:mysql://localhost:3307/iti";
    static String username = "root";
    static String password = "123456";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(url, username, password)) {


            createEmployeeTable(conn);

            insertEmployees(conn);

            printEmployees(conn);

            updateEmployeesWithBatch(conn);

            printEmployees(conn);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createEmployeeTable(Connection conn) throws SQLException {
    try (Statement stmt = conn.createStatement()) {

        // Drop the table if it exists
        String dropTableSQL = "DROP TABLE IF EXISTS Employees";
        stmt.execute(dropTableSQL);

        // Create table again
        String createTableSQL = """
            CREATE TABLE Employees (
                Id INT AUTO_INCREMENT PRIMARY KEY,
                F_Name VARCHAR(50),
                L_Name VARCHAR(50),
                Gender VARCHAR(10),
                Age INT,
                Address VARCHAR(100),
                Phone_Number VARCHAR(20),
                Vacation_Balance INT DEFAULT 30
            )
        """;
        stmt.execute(createTableSQL);

        System.out.println("Employees table dropped (if existed) and created successfully.");
    }
}


    private static void insertEmployees(Connection conn) throws SQLException {
        String insertSQL = "INSERT INTO Employees (F_Name, L_Name, Gender, Age, Address, Phone_Number) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {

            pstmt.setString(1, "John");
            pstmt.setString(2, "Doe");
            pstmt.setString(3, "Male");
            pstmt.setInt(4, 50);
            pstmt.setString(5, "123 Elm St");
            pstmt.setString(6, "111-111-1111");
            pstmt.addBatch();

            pstmt.setString(1, "Jane");
            pstmt.setString(2, "Smith");
            pstmt.setString(3, "Female");
            pstmt.setInt(4, 42);
            pstmt.setString(5, "456 Oak St");
            pstmt.setString(6, "222-222-2222");
            pstmt.addBatch();

            pstmt.setString(1, "Michael");
            pstmt.setString(2, "Brown");
            pstmt.setString(3, "Male");
            pstmt.setInt(4, 55);
            pstmt.setString(5, "789 Pine St");
            pstmt.setString(6, "333-333-3333");
            pstmt.addBatch();

            pstmt.setString(1, "Emily");
            pstmt.setString(2, "Davis");
            pstmt.setString(3, "Female");
            pstmt.setInt(4, 35);
            pstmt.setString(5, "101 Maple St");
            pstmt.setString(6, "444-444-4444");
            pstmt.addBatch();

            pstmt.setString(1, "Robert");
            pstmt.setString(2, "Wilson");
            pstmt.setString(3, "Male");
            pstmt.setInt(4, 48);
            pstmt.setString(5, "202 Cedar St");
            pstmt.setString(6, "555-555-5555");
            pstmt.addBatch();

            int[] results = pstmt.executeBatch();
            System.out.println(results.length + " employees inserted successfully.");
        }
    }

    private static void updateEmployeesWithBatch(Connection conn) throws SQLException {
        String selectSQL = "SELECT Id, F_Name, Gender, Vacation_Balance FROM Employees WHERE Age > 45";
        try (Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)) {

            ResultSet rs = stmt.executeQuery(selectSQL);

            while (rs.next()) {
                int id = rs.getInt("Id");
                String fName = rs.getString("F_Name");
                String gender = rs.getString("Gender");

                rs.updateInt("Vacation_Balance", 45);

                String prefix = gender.equalsIgnoreCase("Male") ? "Mr. " : "Mrs. ";
                rs.updateString("F_Name", prefix + fName);

                rs.updateRow(); 
            }

        }
    }
    private static void printEmployees(Connection conn) throws SQLException {
        System.out.println();
        String query = "SELECT * FROM Employees";
        try (Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query)) {

            System.out.printf("%-5s %-15s %-15s %-8s %-5s %-20s %-15s %-17s%n",
                    "ID", "F_Name", "L_Name", "Gender", "Age", "Address", "Phone", "Vacation_Balance");
            System.out.println("-----------------------------------------------------------------------------------------");

            while (rs.next()) {
                System.out.printf("%-5d %-15s %-15s %-8s %-5d %-20s %-15s %-17d%n",
                        rs.getInt("Id"),
                        rs.getString("F_Name"),
                        rs.getString("L_Name"),
                        rs.getString("Gender"),
                        rs.getInt("Age"),
                        rs.getString("Address"),
                        rs.getString("Phone_Number"),
                        rs.getInt("Vacation_Balance")
                );
            }
        }
}

}
