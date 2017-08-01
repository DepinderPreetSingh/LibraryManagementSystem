package library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDemo {
	private Connection con;
	public Connection conCreate()
	{
		try{
			//System.out.println
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("Driver loaded");
		con=DriverManager.getConnection("jdbc:oracle:thin:@admin-23-pc:1521:XE","hr","hr");
		System.out.println("Connection established");
		}
		catch(ClassNotFoundException x)
		{
			System.out.println("Not found");
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		return con;
	}
	public static void main(String args[])
	{
		ConnectionDemo c2=new ConnectionDemo();
		c2.conCreate();
	}


}
