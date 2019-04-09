package Utilisateurs;

public class Utilisateur {
    String user_familly_name;
    String user_first_name;
    String user_email;
    int size;
    String gender;
    String user_password;

    public Utilisateur(String user_familly_name, String user_first_name, String user_email, int size, String gender, String user_password) {
        this.user_familly_name = user_familly_name;
        this.user_first_name = user_first_name;
        this.user_email = user_email;
        this.size = size;
        this.gender = gender;
        this.user_password = user_password;
    }

    @Override
    public String toString(){
        return "User first name = " + user_first_name + "User familly name = " + user_familly_name + "User email = " + user_email + "User gender = " + gender + "User pwd = " + user_password;
    }
}
