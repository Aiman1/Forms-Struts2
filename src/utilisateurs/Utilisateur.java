package utilisateurs;

public class Utilisateur {
    String user_family_name;
    String user_first_name;
    String user_email;
    int size;
    String gender;
    String user_password;

    public Utilisateur(String user_family_name, String user_first_name, String user_email, int size, String gender, String user_password) {
        this.user_family_name = user_family_name;
        this.user_first_name = user_first_name;
        this.user_email = user_email;
        this.size = size;
        this.gender = gender;
        this.user_password = user_password;
    }
    public Utilisateur(){

    }

    @Override
    public String toString(){
        return "User first name = " + user_first_name + "User family name = " + user_family_name + "User email = " + user_email + "User gender = " + gender + "User pwd = " + user_password;
    }
}
