package dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBHandler {

	public static Connection establishConnection()
	{
		Connection connection=null;
		try
		{
			FileInputStream fis = new FileInputStream("C:/Users/khswami/Documents/PackageQues/src/main/resources/db.properties");
			Properties p = new Properties();
			p.load(fis);
			
			String driver = (String)p.get("driver");
			String url = (String)p.get("url");
			String username = (String)p.get("username");
			String password = (String)p.get("password");
			
			Class.forName(driver);
			connection = DriverManager.getConnection(url, username, password);
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
		return connection;
	
	}
}
