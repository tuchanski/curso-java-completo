package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DB {

    private static Connection conn = null;

    // Method to create a connection with database
    public static Connection getConnection() {
        if (conn == null) {
            try {
                Properties prop = loadProperties();

                // Get URL from dburl property
                String url = prop.getProperty("dburl");

                // Start connection after receiving url and properties of db
                conn = DriverManager.getConnection(url, prop);
            }
            catch (SQLException e) {
                throw new DbException(e.getMessage());
            }

        }
        return conn;
    }

    // Method to load properties from db.properties
    private static Properties loadProperties(){
        String path = "properties/db.properties";

        try (FileInputStream fis = new FileInputStream(path)){
            Properties prop = new Properties();
            prop.load(fis);
            return prop;
        }
        catch (IOException e){
            throw new DbException(e.getMessage());
        }
    }

    // Method to close db connection
    public static void closeConnection(){
        if (conn != null) {
            try {
                conn.close();
            }
            catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }

}
