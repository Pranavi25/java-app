package ca.jrvs.apps.jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataBaseConnectionManager {
    private final String url;
    private final Properties properties;
    //Constructor
    public DataBaseConnectionManager(String host, String databaseName, String username, String password){
        this.url = "jdbc:postgresql://"+host+"/"+databaseName;
        this.properties = new Properties(); //instantiate the properties
        this.properties.setProperty("user",username);
        this.properties.setProperty("password",password);
    }

    //method for connection
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(this.url,this.properties);
    }

}
