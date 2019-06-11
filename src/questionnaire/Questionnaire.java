package questionnaire;

import java.util.List;

public class Questionnaire {
    private int id;
    private Boolean statut;
    private int idSujet;
    private String intitule;
    private List<Question> questions;

    
    
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



	public List<Question> getQuestions(){return this.questions;}


	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	public void setIdSujet(int idSujet) {
		this.idSujet = idSujet;
	}
}
