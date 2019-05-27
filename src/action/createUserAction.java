package action;

import java.sql.SQLException;

import dao.StagiaireDAO;
import utilisateurs.Stagiaire;
import utilisateurs.Utilisateur;

public class createUserAction {
    Stagiaire user = new Stagiaire();
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
            try {
				if (new StagiaireDAO().create(user) == 1)
				    return "success";
				else
				    return "failure";
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return e.toString();
			}
        }
    }
}
