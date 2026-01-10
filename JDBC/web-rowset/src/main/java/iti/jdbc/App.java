package iti.jdbc;

import java.io.FileWriter;
import java.io.FileOutputStream;
import java.io.FileOutputStream;
import java.net.CacheRequest;
import java.sql.*;

import javax.sql.RowSet;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.WebRowSet;

import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import com.mysql.cj.jdbc.AbandonedConnectionCleanupThread;

public class App 
{
    RowSetFactory factory;
    WebRowSet web;
    public App(){
        String url = "jdbc:mysql://localhost:3307/iti";
        String username = "root";
        String password = "123456";

    try{

        factory = RowSetProvider.newFactory();
        web = factory.createWebRowSet();
        web.setUrl(url);
        web.setUsername(username);
        web.setPassword(password);
        web.setCommand("select fname, lname, ssn, bdate, salary from employee");
        web.execute();
        load();

        FileOutputStream out = new FileOutputStream("empl.xml");
        web.writeXml(out);

    }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            AbandonedConnectionCleanupThread.checkedShutdown();
            try{
                web.close();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    void load() throws Exception{
        web.beforeFirst();
        System.out.printf("%-12s %-12s %-12s %-12s %-10s%n", "fname", "lname", "SSN", "Birth Date", "Salary");

        while (web.next()) {
            System.out.printf("%-12s %-12s %-12s %-12s %-10d%n",
                web.getString("fname"),  
                web.getString("lname"),          
                web.getString("ssn"),            
                web.getDate("bdate"),            
                web.getInt("salary")          
            );
        }
        System.out.println();
    }
    public static void main( String[] args )
    {
        new App();
    }
}
