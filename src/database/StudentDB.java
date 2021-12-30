
package database;

import java.sql.Connection;
import java.sql.DriverManager;


public class StudentDB {
    
    
      static Connection connection;
    static String driver = "com.mysql.jdbc.Driver";
    static String url = "jdbc:mysql://@localhost:3307/student";
    //static String url = "jdbc:mysql://@localhost:3307/student";
    static String username ="root";
    static String password ="password";
    
    public static Connection getConnection() throws Exception{
        
    if(connection == null){
        Class.forName(driver);
        connection =  DriverManager.getConnection(url, username, password);
    }    
        
        
        return connection;
    

    
    }
}
