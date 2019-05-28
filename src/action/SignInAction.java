package action;

import com.opensymphony.xwork2.ActionSupport;
import dao.CompteDAO;
import org.apache.struts2.interceptor.SessionAware;
import utilisateurs.Compte;

import java.util.Map;

public class SignInAction extends ActionSupport implements SessionAware {

    private Compte compte = new Compte();

    private Map<String, Object> session;


    public SignInAction(){

    }

    public String execute(){
        System.out.println("-----------------------------");
        System.out.println(compte.toString());
        System.out.println("-----------------------------");

        CompteDAO dao = new CompteDAO();
        if (dao.isAdmin(compte)) {
            session.put("admin", true);
            session.put("user",dao.getName(compte));
            return "admin";
        }
        else if(dao.isStagiaire(compte)) {
            session.put("admin", false);
            session.put("user",dao.getName(compte));
            return "stagiaire";
        }
        else {
            session.put("unknown", true);
            session.put("user","not connected");
            return "unknown";
        }
    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.session = map;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }

    public Compte getCompte() {
        return compte;
    }
}
