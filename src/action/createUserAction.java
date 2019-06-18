package action;

import com.opensymphony.xwork2.ActionSupport;
import dao.AdministrateurDAO;
import dao.StagiaireDAO;
import org.apache.struts2.interceptor.SessionAware;
import utilisateurs.Administrateur;
import utilisateurs.Stagiaire;

import java.sql.SQLException;
import java.util.Map;

public class createUserAction extends ActionSupport implements SessionAware {
    private Stagiaire stagiaire = new Stagiaire();
    private String admin;
    private Map<String, Object> session;

    public createUserAction(){

    }

    public String execute(){
        //if(!session.get("admin"))return "";
        System.out.println("user" + stagiaire.toString());
        if (stagiaire == null) return "failure";
        if (!session.get("admin").equals(true)){
            return "failure";
        }
        else if (admin.compareTo("true") == 1){
            try { ;
                //stagiaire.getCompte().setCreePar(session.get("user"));
                if (new AdministrateurDAO().create(stagiaire) == 1)
                    return "success";
                else
                    return "failure";
            } catch (SQLException e) {
                e.printStackTrace();
                return "failure";
            }
        }
        else {
            try {
                stagiaire.setActif(true);
                //stagiaire.getCompte().setCreePar(session.get("user"));
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

    public Stagiaire getStagiaire() {
        return stagiaire;
    }

    public void setStagiaire(Stagiaire stagiaire) {
        this.stagiaire = stagiaire;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.session = map;
    }
}
