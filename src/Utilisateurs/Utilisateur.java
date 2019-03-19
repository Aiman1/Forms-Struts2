package Utilisateurs;

public abstract class Utilisateur {
    private String nom;
    private String Société;
    private String coord;
    private compte c;

    public abstract void authentification(String addrMail, String pwd);
}
