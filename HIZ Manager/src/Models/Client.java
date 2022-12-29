package Models;


import java.util.ArrayList;

public class Client extends Personne {
   
	private String CIN;
    ArrayList<Integer> eventList =new ArrayList<Integer>();

	public String getCIN() {
		return CIN;
	}

	public void setCIN(String cIN) {
		CIN = cIN;
	}

	public Client(String cIN,int iD, String email, String name, String phoneNum) {
		super(iD,email,name,phoneNum);
		CIN = cIN;
	}
    
}
