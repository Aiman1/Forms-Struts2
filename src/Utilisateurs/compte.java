package Utilisateurs;

public class compte {
    private String email;
    private String mdp;
    private Utilisateur creerPar;

    public compte(String email,String mdp, Utilisateur creerPar){
        assert(mdp.length() >= 6);
        this.email = email;
        this.mdp = mdp;
    }
}
