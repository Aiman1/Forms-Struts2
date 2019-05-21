package utilisateurs;

public class Stagiaire extends Utilisateur {
	
    public Stagiaire(){

	}
    public Stagiaire(int id, String family_name, String first_name, String tel, String societe,
			String gender, boolean actif, Compte compte) {
		super(id, family_name, first_name, tel, societe, gender, actif, compte);
		// TODO Auto-generated constructor stub
	}



	public void authentification(String addrMail, String pwd) {

    }
	@Override
	public Boolean isAdmin(){
		return false;
	}
}
