package iti.jdbc;

import java.sql.*;
import com.mysql.cj.jdbc.AbandonedConnectionCleanupThread;

public class App 
{
    public App(){
        String url = "jdbc:mysql://localhost:3307/iti";
        String username = "root";
        String password = "123456";

        try(Connection con = DriverManager.getConnection(url, username, password);
            PreparedStatement ps = con.prepareStatement("select CONCAT(fname,lname) as name, ssn, bdate, salary from employee");
            ResultSet rs = ps.executeQuery()){

            System.out.printf("%-25s %-12s %-12s %-10s%n", "Name", "SSN", "Birth Date", "Salary");

            System.out.println();

            while (rs.next()) {
                System.out.printf("%-25s %-12s %-12s %-10d%n",
                    rs.getString("name"),           
                    rs.getString("ssn"),            
                    rs.getDate("bdate"),            
                    rs.getInt("salary")          
                );
            }

        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            AbandonedConnectionCleanupThread.checkedShutdown();
        }
    }
    public static void main( String[] args )
    {
        new App();
    }
}
