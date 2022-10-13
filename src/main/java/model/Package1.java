package model;

public class Package1 {

	String packageId;
	String sourcePlace;
	String destinationPlace;
	double basicFare;
	int noOfDays;
	double packageCost;
	
	public String getPackageId() {
		return packageId;
	}
	public void setPackageId(String packageId) {
		this.packageId = packageId;
	}
	public String getSourcePlace() {
		return sourcePlace;
	}
	public void setSourcePlace(String sourcePlace) {
		this.sourcePlace = sourcePlace;
	}
	public String getDestinationPlace() {
		return destinationPlace;
	}
	public void setDestinationPlace(String destinationPlace) {
		this.destinationPlace = destinationPlace;
	}
	public double getBasicFare() {
		return basicFare;
	}
	public void setBasicFare(double basicFare) {
		this.basicFare = basicFare;
	}
	public int getNoOfDays() {
		return noOfDays;
	}
	public void setNoOfDays(int noOfDays) {
		this.noOfDays = noOfDays;
	}
	public double getPackageCost() {
		return packageCost;
	}
	public void setPackageCost(double packageCost) {
		this.packageCost = packageCost;
	}
	
	

	public Package1(String packageId, String sourcePlace, String destinationPlace, double basicFare, int noOfDays) 
	{
		super();
		this.packageId = packageId;
		this.sourcePlace = sourcePlace;
		this.destinationPlace = destinationPlace;
		this.basicFare = basicFare;
		this.noOfDays = noOfDays;
	}
	
	
	
	public void calculatePackageCost()
	{
		
		if(getNoOfDays()<=5) 
		{
			packageCost = basicFare*noOfDays;
			return;
		}
		if(getNoOfDays()>5 && getNoOfDays()<=8) 
		{
			packageCost = basicFare*noOfDays*0.97;
			return;
		}
		if(getNoOfDays()>8 && getNoOfDays()<=10) 
		{
			packageCost = basicFare*noOfDays*0.95;
			return;
		}
		if(getNoOfDays()>10) 
		{
			packageCost = basicFare*noOfDays*0.93;
			return;
		}
		
		packageCost*=1.12;
	
	}
}
