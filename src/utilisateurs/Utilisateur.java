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

    public String getUser_family_name() {
		return user_family_name;
	}
	public void setUser_family_name(String user_family_name) {
		this.user_family_name = user_family_name;
	}
	public String getUser_first_name() {
		return user_first_name;
	}
	public void setUser_first_name(String user_first_name) {
		this.user_first_name = user_first_name;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	
	@Override
    public String toString(){
        return "User first name = " + user_first_name + "User family name = " + user_family_name + "User email = " + user_email + "User gender = " + gender + "User pwd = " + user_password;
    }
}
