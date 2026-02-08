package iti.network;


import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonServiceImpl extends UnicastRemoteObject
        implements PersonService {

    private Connection connection;

    protected PersonServiceImpl() throws RemoteException {
        try {
            connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3307/iti",
                "root",
                "123456"
            );
        } catch (SQLException e) {
            e.printStackTrace();;
        }
    }

    @Override
    public void addPerson(Person p) throws RemoteException {
        String sql = """
            INSERT INTO person
            (id, firstname, middlename, lastname, email, phone)
            VALUES (?, ?, ?, ?, ?, ?)
            """;

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, p.getId());
            ps.setString(2, p.getFirstName());
            ps.setString(3, p.getMiddleName());
            ps.setString(4, p.getLastName());
            ps.setString(5, p.getEmail());
            ps.setString(6, p.getPhone());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RemoteException(e.getMessage());
        }
    }

    @Override
    public void updatePerson(Person p) throws RemoteException {
        String sql = """
            UPDATE person SET
            firstname=?, middlename=?, lastname=?, email=?, phone=?
            WHERE id=?
            """;

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, p.getFirstName());
            ps.setString(2, p.getMiddleName());
            ps.setString(3, p.getLastName());
            ps.setString(4, p.getEmail());
            ps.setString(5, p.getPhone());
            ps.setInt(6, p.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RemoteException(e.getMessage());
        }
    }

    @Override
    public void deletePerson(int id) throws RemoteException {
        try (PreparedStatement ps =
             connection.prepareStatement(
                 "DELETE FROM person WHERE id=?")) {

            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RemoteException(e.getMessage());
        }
    }

    @Override
    public Person getPerson(int id) throws RemoteException {
        try (PreparedStatement ps =
             connection.prepareStatement(
                 "SELECT * FROM person WHERE id=?")) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return mapRow(rs);
            }
            return null;
        } catch (SQLException e) {
            throw new RemoteException(e.getMessage());
        }
    }

    @Override
    public List<Person> getAllPersons() throws RemoteException {
        List<Person> list = new ArrayList<>();

        try (Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM person")) {

            while (rs.next()) {
                list.add(mapRow(rs));
            }
        } catch (SQLException e) {
            throw new RemoteException(e.getMessage());
        }
        return list;
    }

    private Person mapRow(ResultSet rs) throws SQLException {
        return new Person(
            rs.getInt("id"),
            rs.getString("firstname"),
            rs.getString("middlename"),
            rs.getString("lastname"),
            rs.getString("email"),
            rs.getString("phone")
        );
    }

    public static void main(String[] args) {
        try {
            PersonService stub = new PersonServiceImpl();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("PersonService", stub);

            while(true){}

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
