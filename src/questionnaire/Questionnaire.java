package questionnaire;

import java.util.ArrayList;

public class Questionnaire {
    private int id;
    private Boolean statut;
    private Sujet sujet;
    private String intitule;
    private ArrayList<Question> questions;

    
    
    public Questionnaire(int id, Boolean statut, Sujet sujet, String intitule) {
		super();
		this.id = id;
		this.statut = statut;
		this.sujet = sujet;
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



	public Sujet getSujet() {
		return sujet;
	}



	public void setSujet(Sujet sujet) {
		this.sujet = sujet;
	}



	public String getIntitule() {
		return intitule;
	}



	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}



	public ArrayList<Question> getQuestions(){return this.questions;}
}
