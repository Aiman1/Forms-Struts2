package DB;

import com.sun.java.util.jar.pack.Package;

import javax.sql.rowset.serial.SerialException;

import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {
    public void init() throws SerialException{
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException ex){
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public connection(){
    	
    }
}
