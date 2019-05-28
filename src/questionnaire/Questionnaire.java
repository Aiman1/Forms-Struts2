package questionnaire;

import java.util.ArrayList;

public class Questionnaire {
    private int id;
    private Boolean statut;
    private int idSujet;
    private String intitule;
    private ArrayList<Question> questions;

    
    
    public Questionnaire(int id, Boolean statut, int sujet, String intitule) {
		super();
		this.id = id;
		this.statut = statut;
		this.idSujet = sujet;
		this.intitule = intitule;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public Boolean getStatut() {
		return statut;
	}



	public void setStatut(Boolean statut) {
		this.statut = statut;
	}



	public int getIdSujet() {
		return idSujet;
	}



	public void setSujet(int sujet) {
		this.idSujet = sujet;
	}



	public String getIntitule() {
		return intitule;
	}



	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}



	public ArrayList<Question> getQuestions(){return this.questions;}
}
