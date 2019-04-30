package Utilisateurs;

import Questionnaire.Question;
import Questionnaire.Questionnaire;
import Questionnaire.Reponse;

import java.util.ArrayList;

public class Administrateur extends Utilisateur {

	public Administrateur(String user_family_name, String user_first_name, String user_email, int size, String gender, String user_password) {
		super(user_family_name, user_first_name, user_email, size, gender, user_password);
	}
	
    public Compte creerCompte() {
        return new Compte("","",this);
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
