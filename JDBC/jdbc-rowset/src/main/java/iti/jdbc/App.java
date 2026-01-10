package iti.jdbc;

import java.sql.*;

import javax.sql.RowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import com.mysql.cj.jdbc.AbandonedConnectionCleanupThread;

public class App 
{
    RowSetFactory factory;
    JdbcRowSet jdbc;
    public App(){
        String url = "jdbc:mysql://localhost:3307/iti";
        String username = "root";
        String password = "123456";
        
    try{
        factory = RowSetProvider.newFactory();
        jdbc = factory.createJdbcRowSet();
        jdbc.setUrl(url);
        jdbc.setUsername(username);
        jdbc.setPassword(password);
        jdbc.setCommand("select CONCAT(fname,lname) as name, ssn, bdate, salary from employee");
        jdbc.execute();
        
        System.out.printf("%-25s %-12s %-12s %-10s%n", "Name", "SSN", "Birth Date", "Salary");


        while (jdbc.next()) {
            System.out.printf("%-25s %-12s %-12s %-10d%n",
                jdbc.getString("name"),           
                jdbc.getString("ssn"),            
                jdbc.getDate("bdate"),            
                jdbc.getInt("salary")          
            );
        }
    }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            AbandonedConnectionCleanupThread.checkedShutdown();
            try{
                jdbc.close();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    public static void main( String[] args )
    {
        new App();
    }
}
