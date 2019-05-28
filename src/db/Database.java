package db;

//import com.sun.java.util.jar.pack.Package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Database {
    private static String DB_HOST = "127.0.0.1:3306/sr03";
    private static String DB_PASSWD = "admin";
    private static String DB_NAME = "root";
    private static Connection connection;
    static{
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://"+ DB_HOST,DB_NAME, DB_PASSWD);
            System.out.println("-----------------------------\n Base de données chargées \n -------------------------------");

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
