package questionnaire;

import java.util.List;

public class Question {
    

    private int id;
    private String intitule;
    private int idQuestionnaire;
    private int nbQuestion;
    private List<Reponse> reponses;
    private Boolean statut;

    public Question(int id, String intitule, Boolean statut, int idQuestionnaire) {
        this.id = id;
        this.intitule = intitule;
        this.statut = statut;
        this.idQuestionnaire = idQuestionnaire;
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

	public int getIdQuestionnaire() {
		return idQuestionnaire;
	}

	public void setIdQuestionnaire(int idQuestionnaire) {
		this.idQuestionnaire = idQuestionnaire;
	}
    public List<Reponse> getReponses(){return this.reponses;}

	public void setReponses(List<Reponse> reponses) {
		this.reponses = reponses;
	}

	public String toString() {
		String res = "id : " + id + ", intitule : " + intitule;
		for(Reponse r : reponses) {
			res = res + " " + r.toString();
		}
		return res;
	}
}
