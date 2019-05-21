package utilisateurs;

public class Compte {
    private String email;
    private String mdp;
    private Utilisateur creePar;
    private static int nbComptes = 0;

    public Compte(){

	}

    public Compte(String email,String mdp){
        assert(mdp.length() >= 6);
        this.email = email;
        this.mdp = mdp;
        nbComptes++;
        //this.creePar = creePar;
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
}
