package Models;

import java.util.ArrayList;

public class EatStuff {
    private double BudgetEat ;
    ArrayList<String> ListFood =new ArrayList<String>();
    Provider provider = new Provider();
	public double getBudgetEat() {
		return BudgetEat;
	}
	public void setBudgetEat(double budgetEat) {
		BudgetEat = budgetEat;
	}
	public ArrayList<String> getListFood() {
		return ListFood;
	}
	public void setListFood(ArrayList<String> listFood) {
		ListFood = listFood;
	}
	public Provider getProvider() {
		return provider;
	}
	public void setProvider(Provider provider) {
		this.provider = provider;
	}
}
