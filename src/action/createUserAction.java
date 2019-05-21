package action;

import dao.StagiaireDAO;
import utilisateurs.Stagiaire;
import utilisateurs.Utilisateur;

import java.sql.SQLException;

public class createUserAction {
    Stagiaire stagiaire = new Stagiaire();
    private Boolean admin;
    public createUserAction(){
        admin = false;
    }

    public String execute(){
        System.out.println("user" + stagiaire);
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
}
