package questionnaire;

public class Reponse {
    private int id;
    private String intitule;
    private Boolean statut;
    private Boolean bonne;
    private int idQuestion;
    
    
	public Reponse(int id, String intitule, Boolean statut, Boolean bonne, int question) {
		super();
		this.id = id;
		this.intitule = intitule;
		this.statut = statut;
		this.bonne = bonne;
		this.idQuestion = question;
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
	
    public int getIdQuestion() {
		return idQuestion;
	}

	public void setIdQuestion(int idQuestion) {
		this.idQuestion = idQuestion;
	}

	public String toString() {
    	System.out.println("id : " + id + ", intitule : " + intitule);
    }

}
