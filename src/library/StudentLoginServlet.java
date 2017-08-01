
package library;
import java.io.IOException;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.*;
/**
 * Servlet implementation class Login
 */
public class StudentLoginServlet extends HttpServlet
{
	Connection con;
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		
		MyConServlet mc=new MyConServlet();
		con= mc.conCreate();	
		RequestDispatcher dis;
		PrintWriter out=res.getWriter();
		try {
			String user=req.getParameter("user");
			if(user.equals("Student"))
			{
			String student_id=(req.getParameter("student_id"));
			String password=(req.getParameter("password"));
			PreparedStatement sta1=con.prepareStatement ("select *  from student_details where  student_id =? and password =?");
			sta1.setString(1,student_id);
			sta1.setString(2,password);
			ResultSet result=sta1.executeQuery();
			
			if(result.next())
			{
				String ISBN=result.getString(1);
				String booktitle=result.getString(2);
				out.println(ISBN+" "+booktitle);
				return;
				//dis=getServletContext().getRequestDispatcher("/WelcomeStudentServlet.html");
				//dis.forward(req,res);
				//out.println("Welcome "+ username);
	    	}
			else
			{
				dis=getServletContext().getRequestDispatcher("/check.html");
				dis.include(req,res);
				out.println("Wrong studentId or password");
			}
			}
			else
			{
				out.println("Under construction");
			}
		
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
