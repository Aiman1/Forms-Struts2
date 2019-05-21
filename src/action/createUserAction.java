package action;

import com.opensymphony.xwork2.ActionSupport;
import dao.StagiaireDAO;
import org.apache.struts2.interceptor.SessionAware;
import utilisateurs.Stagiaire;
import utilisateurs.Utilisateur;

import java.sql.SQLException;
import java.util.Map;

public class createUserAction extends ActionSupport implements SessionAware {
    Stagiaire stagiaire = new Stagiaire();
    private Boolean admin;
    public createUserAction(){
        System.out.println(stagiaire);
        admin = false;
    }

    public String execute(){
        //System.out.println("user" + stagiaire);
        if (admin){
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

    }
}
