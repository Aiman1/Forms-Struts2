package DB;

import com.sun.java.util.jar.pack.Package;

import javax.sql.rowset.serial.SerialException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class database {
    @Override
    public void innit() throws SerialException{
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException ex){
            Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public connection(){

    }
}
