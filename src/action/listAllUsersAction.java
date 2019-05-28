package action;

import com.opensymphony.xwork2.ActionSupport;
import dao.AdministrateurDAO;
import dao.StagiaireDAO;
import org.apache.struts2.interceptor.SessionAware;
import utilisateurs.Administrateur;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class listAllUsersAction extends ActionSupport implements SessionAware {
    private Map<String, Object> session;

    @Override
    public void setSession(Map<String, Object> map) {
        this.session = map;
    }
    public String execute(){
        List <String> list = new ArrayList<String>();
        try {
            for(Administrateur a : new AdministrateurDAO().getAll())
                list.add(a.toString());
        } catch (SQLException e) {
            e.printStackTrace();
            return "failure";
        }
        return "succes";
    }
}
