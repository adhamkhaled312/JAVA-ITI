package iti.jdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.sql.*;
import javax.sql.*;
import com.mysql.cj.jdbc.MysqlDataSource;

public class MyDataSourceFactory {
    public static DataSource getMySqlDataSource(){
        Properties properties = new Properties();
        InputStream is;
        MysqlDataSource mysql=null;
        try{
            is = MyDataSourceFactory.class.getClassLoader().getResourceAsStream("db.properties");
            properties.load(is);
            mysql = new MysqlDataSource();
            mysql.setURL(properties.getProperty("url"));
            mysql.setUser(properties.getProperty("username"));
            mysql.setPassword(properties.getProperty("password"));
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return mysql;
    }
}
