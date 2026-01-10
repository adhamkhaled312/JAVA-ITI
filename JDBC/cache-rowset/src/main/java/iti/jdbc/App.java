package iti.jdbc;

import java.net.CacheRequest;
import java.sql.*;

import javax.sql.RowSet;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import com.mysql.cj.jdbc.AbandonedConnectionCleanupThread;

public class App 
{
    RowSetFactory factory;
    CachedRowSet cache;
    Connection con;
    public App(){
        String url = "jdbc:mysql://localhost:3307/iti";
        String username = "root";
        String password = "123456";



    try{
        con = DriverManager.getConnection(url, username, password);
        con.setAutoCommit(false);

        factory = RowSetProvider.newFactory();
        cache = factory.createCachedRowSet();
        cache.setUrl(url);
        cache.setUsername(username);
        cache.setPassword(password);
        cache.setCommand("select fname, lname, ssn, bdate, salary from employee");
        cache.execute();
        load();

        cache.moveToInsertRow();
        cache.updateString("fname", "John");
        cache.updateString("lname", "Doe");
        cache.updateString("ssn", "55321");
        cache.updateDate("bdate", java.sql.Date.valueOf("1990-05-10"));
        cache.updateInt("salary", 5000);
        cache.insertRow();
        cache.moveToCurrentRow();

        load();

        if (cache.absolute(3)) { 
            cache.updateString("lname", "Hussein");
            cache.updateRow();
        }
        load();

        if (cache.absolute(2)) { 
            cache.deleteRow();
        }

        load();
        cache.acceptChanges(con);
    }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            AbandonedConnectionCleanupThread.checkedShutdown();
            try{
                cache.close();
                con.close();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    void load() throws Exception{
        cache.beforeFirst();
        System.out.printf("%-12s %-12s %-12s %-12s %-10s%n", "fname", "lname", "SSN", "Birth Date", "Salary");

        while (cache.next()) {
            System.out.printf("%-12s %-12s %-12s %-12s %-10d%n",
                cache.getString("fname"),  
                cache.getString("lname"),          
                cache.getString("ssn"),            
                cache.getDate("bdate"),            
                cache.getInt("salary")          
            );
        }
        System.out.println();
    }
    public static void main( String[] args )
    {
        new App();
    }
}
