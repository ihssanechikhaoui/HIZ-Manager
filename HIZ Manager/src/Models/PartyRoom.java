package Models;

public class PartyRoom {
      
	private String  Address;
	
	private double budgetRoom;
	private String name;
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	
	
	public double getBudgetRoom() {
		return budgetRoom;
	}
	public void setBudgetRoom(double budgetRoom) {
		this.budgetRoom = budgetRoom;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
