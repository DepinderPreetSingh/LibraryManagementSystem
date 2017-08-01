package library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyConServlet
 */
public class MyConServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Connection con;
	public Connection conCreate()
	{
		try{
			//System.out.println
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("Driver loaded");
		con=DriverManager.getConnection("jdbc:oracle:thin:@oddy-PC:1521:XE","hr","hr");
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

}
