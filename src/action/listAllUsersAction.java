package action;

import com.opensymphony.xwork2.ActionSupport;
import dao.AdministrateurDAO;
import dao.StagiaireDAO;
import org.apache.struts2.interceptor.SessionAware;
import utilisateurs.Administrateur;
import utilisateurs.Utilisateur;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class listAllUsersAction extends ActionSupport implements SessionAware {
    private Map<String, Object> session;
    ArrayList<Utilisateur> list = new ArrayList<Utilisateur>();

    @Override
    public void setSession(Map<String, Object> map) {
        this.session = map;
    }

    public String execute(){
        try {
            for(Administrateur a : new AdministrateurDAO().getAll())
                list.add(a);
        } catch (SQLException e) {
            e.printStackTrace();
            return "failure";
        }
        System.out.println(list.toString());
        return "success";
    }

    public ArrayList<Utilisateur> getList() {
        return list;
    }

    public void setList(ArrayList<Utilisateur> list) {
        this.list = list;
    }
}
