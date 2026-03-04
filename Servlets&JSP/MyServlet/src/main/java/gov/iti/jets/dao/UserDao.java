package gov.iti.jets.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import gov.iti.jets.entity.User;

public class UserDao {

    public boolean register(User user) {

        String sql = "INSERT INTO users(first_name,last_name,username,password) VALUES(?,?,?,?)";

        try (Connection conn = DBConnection.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getUsername());
            ps.setString(4, user.getPassword());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public User login(String username, String password) {

        String sql = "SELECT * FROM users WHERE username=? AND password=?";

        try (Connection conn = DBConnection.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                User user = new User();
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
                user.setUsername(rs.getString("username"));

                return user;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
    public List<User> search(String keyword) {

    List<User> users = new ArrayList<>();

    String sql = """
        SELECT * FROM users
        WHERE first_name LIKE ?
           OR last_name LIKE ?
           OR username LIKE ?
    """;

    try (Connection conn = DBConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {

        String value = "%" + keyword + "%";

        ps.setString(1, value);
        ps.setString(2, value);
        ps.setString(3, value);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            User user = new User();
            user.setFirstName(rs.getString("first_name"));
            user.setLastName(rs.getString("last_name"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));

            users.add(user);
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return users;
}
}
