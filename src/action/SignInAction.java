package action;

import com.opensymphony.xwork2.ActionSupport;
import dao.CompteDAO;
import org.apache.struts2.interceptor.SessionAware;
import utilisateurs.Compte;

import java.util.Map;

public class SignInAction extends ActionSupport implements SessionAware {

    Compte compte = new Compte();

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }


    public SignInAction(){

    }

    public String execute(){
        CompteDAO dao = new CompteDAO();
        if (dao.isAdmin(compte))
            return "admin";
        else if(dao.isStagiaire(compte))
            return "stagiaire";
        else
            return "unknown";
    }

    @Override
    public void setSession(Map<String, Object> map) {

    }
}
