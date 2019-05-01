package Questionnaire;

import java.util.ArrayList;

public class Question {
    public Question(int id, String intitule, ArrayList<Reponse> reponses, Boolean statut) {
        this.id = id;
        this.intitule = intitule;
        this.reponses = reponses;
        this.statut = statut;
    }

    private int id;
    private String intitule;
    private ArrayList<Reponse> reponses;
    private Boolean statut;
    public ArrayList<Reponse> getReponses(){return this.reponses;}
}
