package action;

import dao.StagiaireDAO;
import utilisateurs.Stagiaire;
import utilisateurs.Utilisateur;

public class createUserAction {
    Utilisateur user = new Stagiaire();
    private Boolean admin;
    public createUserAction(){
        admin = false;
    }

    public String execute(){
        System.out.println("user"+user);
        if (admin){
            //TODO
            return "failure";
        }
        else {
            if (new StagiaireDAO().create(user) == 1)
                return "success";
            else
                return "failure";
        }
    }
}
