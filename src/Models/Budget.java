package Models;

import java.util.ArrayList;

public class Budget {
	
    private double Avance;
    ArrayList<Integer> featureBudg =new ArrayList<Integer>();
    private int TotalBudg;
	public double getAvance() {
		return Avance;
	}
	public void setAvance(double avance) {
		Avance = avance;
	}
	public ArrayList<Integer> getFeatureBudg() {
		return featureBudg;
	}
	public void setFeatureBudg(ArrayList<Integer> featureBudg) {
		this.featureBudg = featureBudg;
	}
	public int getTotalBudg() {
		return TotalBudg;
	}
	public void setTotalBudg(int totalBudg) {
		TotalBudg = totalBudg;
	}
    
    
}
