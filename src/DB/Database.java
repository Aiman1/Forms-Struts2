package DB;

//import com.sun.java.util.jar.pack.Package;

import javax.sql.rowset.serial.SerialException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Database {
    private static String DB_HOST = "127.0.0.1";
    private static String DB_PASSWD = "";
    private static String DB_NAME = "sr03";
    private static Connection connection;
    static{
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://"+ DB_HOST,DB_NAME, DB_PASSWD);
        }catch (ClassNotFoundException ex){
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection(){
    	return connection;
    }
}
