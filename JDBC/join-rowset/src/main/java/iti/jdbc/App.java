package iti.jdbc;

import java.net.CacheRequest;
import java.sql.*;

import javax.sql.RowSet;
import javax.sql.rowset.JoinRowSet;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import com.mysql.cj.jdbc.AbandonedConnectionCleanupThread;

public class App 
{
    RowSetFactory factory;
    CachedRowSet empls, deps;
    Connection con;
    JoinRowSet join;
    public App(){
        String url = "jdbc:mysql://localhost:3307/iti";
        String username = "root";
        String password = "123456";

    try{
        con = DriverManager.getConnection(url, username, password);
        con.setAutoCommit(false);

        factory = RowSetProvider.newFactory();

        empls = factory.createCachedRowSet();
        empls.setUrl(url);
        empls.setUsername(username);
        empls.setPassword(password);
        empls.setCommand("select fname, lname, ssn, bdate, salary, dno from employee where dno is not null");
        empls.execute();

        deps = factory.createCachedRowSet();
        deps.setUrl(url);
        deps.setUsername(username);
        deps.setPassword(password);
        deps.setCommand("select dno, dname, mgrssn from department");
        deps.execute();

        join = factory.createJoinRowSet();
        join.addRowSet(empls,"dno");
        join.addRowSet(deps,"dno");

        load();



    }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            AbandonedConnectionCleanupThread.checkedShutdown();
            try{
                join.close();
                empls.close();
                deps.close();
                con.close();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    void load() throws Exception{
        join.beforeFirst();

        System.out.printf("%-20s %-15s %-10s%n", "Employee Name", "Department", "Salary");
        while (join.next()) {
            String fullName = join.getString("fname") + " " + join.getString("lname");
            String deptName = join.getString("dno");
            int salary = join.getInt("salary");

            System.out.printf("%-20s %-15s %-10d%n", fullName, deptName, salary);
        }
        System.out.println();
    }
    public static void main( String[] args )
    {
        new App();
    }
}
