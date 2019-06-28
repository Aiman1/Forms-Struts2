package parcours;

import questionnaire.Questionnaire;
import questionnaire.Reponse;
import utilisateurs.Utilisateur;

import java.util.List;
import java.util.Optional;

public class    Parcours {
    private int id;
    private double duree;
    private int score;
    private int idUtilisateur;
    private int idQuestionnaire;
    private String intitule;
    private List<Reponse> reponses;

    public Parcours(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Parcours(int id, double duree, int score, int idUtilisateur, int idQuestionnaire) {
        this.id = id;
        this.idUtilisateur = idUtilisateur;
        this.idQuestionnaire = idQuestionnaire;
        this.duree = duree;
        this.score = score;
    }

    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setU(int u) {
        this.idUtilisateur = u;
    }

    public int getIdQuestionnaire() {
        return idQuestionnaire;
    }

    public void setQ(int id) {
        this.idQuestionnaire =  id;
    }

    public double getDuree() {
        return duree;
    }

    public void setDuree(double duree) {
        this.duree = duree;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }


    public String getIntitule() {
        return intitule;
    }


    public boolean getStatut() {
        return true;
    }
}
