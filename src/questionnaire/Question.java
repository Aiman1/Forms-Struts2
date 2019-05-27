package questionnaire;

import java.util.ArrayList;

public class Question {
    

    private int id;
    private String intitule;
    private ArrayList<Reponse> reponses;
    private Boolean statut;
    public ArrayList<Reponse> getReponses(){return this.reponses;}
    
    public Question(int id, String intitule, Boolean statut) {
        this.id = id;
        this.intitule = intitule;
        this.statut = statut;
    }
    public Question(){}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public Boolean getStatut() {
		return statut;
	}

	public void setStatut(Boolean statut) {
		this.statut = statut;
	}
}
