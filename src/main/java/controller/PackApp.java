package controller;

import model.Package1;
import utility.TravelAgency;

public class PackApp {
	
	static String f = "C:/Users/khswami/Documents/PackageQues/VarshTourPackageDetails.txt";

		public static void main(String[] args) 
		{
			// TODO Auto-generated method stub
			TravelAgency t=new TravelAgency();
			try 
			{
				System.out.println("/n/n***************loading cost*******************");
				for(Package1 p:t.generatePackageCost(f)) 
				{
					System.out.println(p.getPackageId()+"    "+p.getSourcePlace()+"-"+p.getDestinationPlace()+"    "+p.getNoOfDays()+" days    Rs. "+p.getPackageCost());
				}
				
				System.out.println("\n\n********************By No. of Days********************");
				for(Package1 p:t.findPackagesWithMinimumNumberOfDays())
				{
					System.out.println(p.getPackageId()+"    "+p.getSourcePlace()+"-"+p.getDestinationPlace()+"    "+p.getNoOfDays()+" days    Rs. "+p.getPackageCost());
				}
			}
			catch(Exception ex) {
				System.out.println(ex.getMessage());
			}
		}

	
	
}
