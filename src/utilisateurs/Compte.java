package utilisateurs;

public class Compte {
    private int id;
	private String email;
    private String mdp;
    private Utilisateur creePar;
    private static int nbComptes = 0;

    public Compte(){

	}

    public Compte(int id,String email,String mdp){
        assert(mdp.length() >= 6);
        this.id=id;
        this.email = email;
        this.mdp = mdp;
        nbComptes++;
        //this.creePar = creePar;
    }

    
    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String toString(){
    	return "email:" + email + " mdp:" + mdp ;
	}
}
