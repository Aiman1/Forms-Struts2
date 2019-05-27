package questionnaire;

public class Reponse {
    private int id;
    private String intitule;
    private Boolean statut;
    private Boolean bonne;
    private Question question;
    
    
	public Reponse(int id, String intitule, Boolean statut, Boolean bonne, Question question) {
		super();
		this.id = id;
		this.intitule = intitule;
		this.statut = statut;
		this.bonne = bonne;
		this.question = question;
	}
	
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
	public Boolean getBonne() {
		return bonne;
	}
	public void setBonne(Boolean bonne) {
		this.bonne = bonne;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}
    
    

}
