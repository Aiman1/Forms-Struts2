package parcours;

import questionnaire.Questionnaire;
import questionnaire.Reponse;
import utilisateurs.Utilisateur;

import java.util.List;

public class    Parcours {
    private int id;
    private double duree;
    private int score;
    private int idUtilisateur;
    private int idQuestionnaire;
    private List<Reponse> reponses;

    public Parcours(){

    }

    public Parcours(int id, double duree, int score, int idUtilisateur, int idQuestionnaire) {
        this.id = id;
        this.idUtilisateur = idUtilisateur;
        this.idQuestionnaire = idQuestionnaire;
        this.duree = duree;
        this.score = score;
    }

    public Utilisateur getU() {
        return u;
    }

    public void setU(Utilisateur u) {
        this.u = u;
    }

    public Questionnaire getQ() {
        return q;
    }

    public void setQ(Questionnaire q) {
        this.q = q;
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
}
