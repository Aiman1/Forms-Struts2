package utilisateurs;

public class Compte {
    private String email;
    private String mdp;
    private Utilisateur creePar;

    public Compte(String email,String mdp, Utilisateur creePar){
        assert(mdp.length() >= 6);
        this.email = email;
        this.mdp = mdp;
        this.creePar = creePar;
    }
}
