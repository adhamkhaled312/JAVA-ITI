package gov.iti.jets.dao;

import java.sql.*;

public class DBConnection {

    private static final String URL =
        "jdbc:mysql://localhost:3306/iti";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";

    public static Connection getConnection() throws SQLException,ClassNotFoundException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}