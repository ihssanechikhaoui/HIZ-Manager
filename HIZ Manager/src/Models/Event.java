package Models;

import java.util.Date;

public class Event {

	Budget budget = new Budget();
	private Date dateEvent = new Date();
	private EatStuff eatStuff = new EatStuff();
	private int nbrGuets;
	private PartyRoom partyRoom = new PartyRoom();
	private TypeEvent typeOfEvent;
	
	public Budget getBudget() {
		return budget;
	}
	public void setBudget(Budget budget) {
		this.budget = budget;
	}
	public Date getDateEvent() {
		return dateEvent;
	}
	public void setDateEvent(Date dateEvent) {
		this.dateEvent = dateEvent;
	}
	public EatStuff getEatStuff() {
		return eatStuff;
	}
	public void setEatStuff(EatStuff eatStuff) {
		this.eatStuff = eatStuff;
	}
	public int getNbrGuets() {
		return nbrGuets;
	}
	public void setNbrGuets(int nbrGuets) {
		this.nbrGuets = nbrGuets;
	}
	public PartyRoom getPartyRoom() {
		return partyRoom;
	}
	public void setPartyRoom(PartyRoom partyRoom) {
		this.partyRoom = partyRoom;
	}
	public TypeEvent getTypeOfEvent() {
		return typeOfEvent;
	}
	public void setTypeOfEvent(TypeEvent typeOfEvent) {
		this.typeOfEvent = typeOfEvent;
	}
	
	
}
