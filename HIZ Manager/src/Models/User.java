package Models;

import java.io.Serializable;
import java.util.ArrayList;

public class User extends Personne implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -8608283269779295105L;
	private int id;
	
	private String HintPassword ;
    private String Password;
    private String Username;
    ArrayList<Integer> taskList =new ArrayList<Integer>();
    
    
    
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHintPassword() {
		return HintPassword;
	}
	public void setHintPassword(String hintPassword) {
		HintPassword = hintPassword;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
    
}
