package utilisateurs;

public abstract class Utilisateur {
	int id;
    String family_name;
    String first_name;
    String tel;
    String societe;
    String gender;
    boolean actif;
    Compte compte;

   
	public Compte getCompte() {
		return compte;
	}
	public void setCompte(Compte compte) {
		this.compte = compte;
	}
	public Utilisateur(){

	}
	public Utilisateur(int id, String family_name, String first_name, String tel, String societe,
			String gender, boolean actif, Compte compte) {
		this.id = id;
		this.family_name = family_name;
		this.first_name = first_name;
		this.tel = tel;
		this.societe = societe;
		this.gender = gender;
		this.actif = actif;
		this.compte = compte;
	}

	public int getId() {
		return id;
	}

	public abstract Boolean isAdmin();


	public void setId(int id) {
		this.id = id;
	}



	public String getFamily_name() {
		return family_name;
	}



	public void setFamily_name(String family_name) {
		this.family_name = family_name;
	}



	public String getFirst_name() {
		return first_name;
	}



	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}





	public String getTel() {
		return tel;
	}



	public void setTel(String tel) {
		this.tel = tel;
	}



	public String getSociete() {
		return societe;
	}



	public void setSociete(String societe) {
		this.societe = societe;
	}



	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}



	public boolean isActif() {
		return actif;
	}



	public void setActif(boolean actif) {
		this.actif = actif;
	}



	@Override
    public String toString(){
        return "";
        //return "User first name = " + first_name + "\nUser family name = " + family_name + "\nUser email = " + user_email + "User gender = " + gender + "User pwd = " + user_password;
    }
}
