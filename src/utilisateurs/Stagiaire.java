package utilisateurs;

public class Stagiaire extends Utilisateur {
	public Stagiaire(){
		
	}
	public Stagiaire(String user_family_name, String user_first_name, String user_email, int size, String gender, String user_password) {
		super(user_family_name, user_first_name, user_email, size, gender, user_password);
	}
	
    
    public void authentification(String addrMail, String pwd) {

    }
}
