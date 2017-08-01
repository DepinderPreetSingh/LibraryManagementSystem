
package library;
import java.io.IOException;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.*;
/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet
{
	Connection con;
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		
		MyConServlet mc=new MyConServlet();
		con= mc.conCreate();	
		RequestDispatcher dis;
		PrintWriter out=res.getWriter();
//
		try {
			String user=req.getParameter("user");
			if(user.equals("Student"))
			{
			String xr=(String)req.getParameter("id");
			int student_id=Integer.parseInt(xr);
			String password=(req.getParameter("password"));
			
			PreparedStatement sta1=con.prepareStatement ("select *  from student_details where  student_id =? and password =?");
			sta1.setInt(1,student_id);
			sta1.setString(2,password);
			ResultSet result=sta1.executeQuery();
			
			if(result.next())
			{
				HttpSession mysession = req.getSession();
				mysession.setAttribute("name", xr);
				String ISBN=result.getString(1);
				String booktitle=result.getString(2);
				out.println(ISBN+" "+booktitle);
				//return;
				//String xr=(String)student_id;
				//req.setAttribute("id",xr);
				getServletContext().setAttribute("pp",xr);
				//System.out.println("value of pp"+xr);
				dis=getServletContext().getRequestDispatcher("/WelcomeStudent.jsp");
				dis.forward(req,res);
				//out.println("Welcome "+ username);
	    	}
			else
			{
				
				dis=getServletContext().getRequestDispatcher("/login.jsp");
				dis.include(req,res);
				out.println("Wrong studentId or password");
			}
			}
			
			
			else if(user.equals("Librarian"))
			{
				//out.println("Under construction");
				String xr=(String)req.getParameter("id");
				int librarian_id=Integer.parseInt(xr);
				String password=(req.getParameter("password"));
				PreparedStatement sta1=con.prepareStatement ("select *  from librarian_details where  librarian_id =? and password =?");
				sta1.setInt(1,librarian_id);
				sta1.setString(2,password);
				ResultSet result=sta1.executeQuery();
				if(result.next())
				{
					HttpSession mysession = req.getSession();
					mysession.setAttribute("name", xr);
					
					String ISBN=result.getString(1);
					String booktitle=result.getString(2);
					out.println(ISBN+" "+booktitle);
					//return;
					//String xr=(String)student_id;
					//req.setAttribute("id",xr);
					getServletContext().setAttribute("pp",xr);
					//System.out.println("value of pp"+xr);
					dis=getServletContext().getRequestDispatcher("/WelcomeLibrarian.jsp");
					dis.forward(req,res);
					//out.println("Welcome "+ username);
		    	}
				else
				{
					
					dis=getServletContext().getRequestDispatcher("/login.jsp");
					dis.include(req,res);
					out.println("Wrong LibrarianId or password");
				}
			}
		
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
