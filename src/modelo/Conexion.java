
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;



public class Conexion {
    public static final String URL = "jdbc:mysql://localhost:3306/escuela?autoReconnect=true&useSSL=false";
    public static final String usuario = "root";
    public static final String password = "1981";
    public static final String driver = "com.mysql.cj.jdbc.Driver";
    
    Connection conexion;
    
    
    public Connection getConnection(){
        Connection conexion = null;
        try {
            Class.forName(driver);
            conexion = (Connection) DriverManager.getConnection(URL, usuario, password);
            
            
        } catch (Exception e) {
            System.err.println("Error, "+e);
        }
        return conexion;
    }
}
