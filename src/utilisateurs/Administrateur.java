package utilisateurs;

import java.util.ArrayList;

import questionnaire.Question;
import questionnaire.Questionnaire;
import questionnaire.Reponse;

public class Administrateur extends Utilisateur {

	
    public Administrateur(int id, String family_name, String first_name, String tel, String societe,
			String gender, boolean actif, Compte compte) {
		super(id, family_name, first_name, tel, societe, gender, actif, compte);
		// TODO Auto-generated constructor stub
	}


	public Compte creerCompte() {
        return new Compte("","");
    }

    
    public void authentification(String addrMail, String pwd) {

    }
    public void modifierOrdreReponse(Question q){
        ArrayList<Reponse> reponses = q.getReponses();
    }

    public void modifierOrdreQuestion(Questionnaire q){
        ArrayList<Question> questions = q.getQuestions();
    }
}
