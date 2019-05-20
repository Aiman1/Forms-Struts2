package questionnaire;

import java.util.List;

import questionnaire.Questionnaire;

public class Sujet {
    private int id;
    private String sujet;
    private List<Questionnaire> questionnaires;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSujet() {
		return sujet;
	}
	public void setSujet(String sujet) {
		this.sujet = sujet;
	}
}
