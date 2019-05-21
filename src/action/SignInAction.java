package action;

import dao.CompteDAO;
import utilisateurs.Compte;

public class SignInAction {

    Compte compte = new Compte();
    private Boolean admin;

    public SignInAction(){
        admin = false;
    }

    public String execute(){
        System.out.println("user"+compte);
        if (new CompteDAO().find(compte) == true)
            return "success";
        else
            return "failure";
    }
}
