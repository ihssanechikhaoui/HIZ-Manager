package Models;

public class Personne {
    private int ID;
    private String Email;
    private String Name;
    private String PhoneNum;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getName() {
		return Name;
	}
	public Personne() {
		super();
	}
	public Personne(int iD, String email, String name, String phoneNum) {
		super();
		ID = iD;
		Email = email;
		Name = name;
		PhoneNum = phoneNum;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getPhoneNum() {
		return PhoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		PhoneNum = phoneNum;
	}
    
}
