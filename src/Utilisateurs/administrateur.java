package Utilisateurs;

import Questionnaire.question;
import Questionnaire.questionnaire;
import Questionnaire.réponse;

import java.util.ArrayList;

public class administrateur extends Utilisateur {


    public compte creerCompte() {
        return new compte("","",this);
    }

    @Override
    public void authentification(String addrMail, String pwd) {

    }
    public void modifierOrdreRéponse(question q){
        ArrayList<réponse> réponses = q.getRéponses();
    }

    public void modifierOrdreQuestion(questionnaire q){
        ArrayList<question> questions = q.getQuestions();
    }
}
