package utility;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dao.DBHandler;
import model.Package1;


public class TravelAgency {
	
	

	public List<Package1> generatePackageCost (String f) throws Exception 
	{
		File file = new File(f);
		Scanner s =  new Scanner(file);
		List<Package1> list = new ArrayList();
		Connection cnn=DBHandler.establishConnection();
		
		
			
		while (s.hasNextLine()) 
		{

			String arr[] = s.nextLine().split(",");

			String id = arr[0].trim();
			
			if (validate(id)) 
			{

				PreparedStatement ps=cnn.prepareStatement("insert into Package_Details values(?,?,?,?,?)");
				PreparedStatement prs=cnn.prepareStatement("select * from Package_Details where package_id=?");
				String source_place = arr[1].trim();
				String destination_place = arr[2].trim();
				int days = Integer.parseInt(arr[3].trim());
				double basic_fare = Double.parseDouble(arr[4].trim());
				Package1 P1 = new Package1(id, source_place, destination_place,basic_fare,days);
				P1.calculatePackageCost();
				list.add(P1);
				ps.setString(1, id);
				ps.setString(2,source_place);
				ps.setString(3,destination_place);
				ps.setInt(4,days);
				ps.setDouble(5,P1.getPackageCost());
				prs.setString(1, id);
				ResultSet rs=prs.executeQuery();
				if(!rs.next())ps.executeUpdate();
				
			} 
			else 
			{
				System.out.println("Invalid Id passed");
			}
		}
		s.close();

		return list;
	}
		
	
	
	public boolean validate(String packageId)
	{
		String regex = "[0-9]{3}[/]{1}[A-Z]{3}";
		return packageId.matches(regex);
	}
	
	public List<Package1> findPackagesWithMinimumNumberOfDays()
	{
		List<Package1> list = new ArrayList();
		try {
			Connection connection = DBHandler.establishConnection();

			PreparedStatement ps = connection.prepareStatement("select * from Package_Details where no_of_days=(select MIN(no_of_days) from Package_Details)");
            
			ResultSet rs = ps.executeQuery();
			while (rs.next()) 
			{

				String id = rs.getString("package_id");
				String src = rs.getString("source_place");
				String dstn = rs.getString("destination_place");
				int days = rs.getInt("no_of_days");
				double cost = rs.getDouble("package_cost");

				Package1 v1 = new Package1(id, src, dstn, 0.0, days);
				v1.setPackageCost(cost);
				list.add(v1);

			}

		} catch (Exception ex) 
		{
			System.out.println(ex.getMessage());
		}
		return list;
	}
	
	
}

