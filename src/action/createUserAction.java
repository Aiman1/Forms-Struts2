package action;

import com.opensymphony.xwork2.ActionSupport;
import dao.StagiaireDAO;
import org.apache.struts2.interceptor.SessionAware;
import utilisateurs.Stagiaire;

import java.sql.SQLException;
import java.util.Map;

public class createUserAction extends ActionSupport implements SessionAware {
    private Stagiaire stagiaire = new Stagiaire();

    private Map<String, Object> session;

    public createUserAction(){

    }

    public String execute(){
        System.out.println("user" + stagiaire);
        if (session.get("admin").equals(true)){
            //TODO
            return "failure";
        }
        else {
            try {
                if (new StagiaireDAO().create(stagiaire) == 1)
                    return "success";
                else
                    return "failure";
            } catch (SQLException e) {
                e.printStackTrace();
                return "failure";
            }
        }
    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.session = map;
    }
}
