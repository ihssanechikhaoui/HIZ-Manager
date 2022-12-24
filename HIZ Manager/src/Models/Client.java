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
    
}
