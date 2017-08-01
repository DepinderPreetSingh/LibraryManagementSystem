package library;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchByTitleServlet
 */
public class SearchByTitleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Connection con;
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		
		MyConServlet mc=new MyConServlet();
		con= mc.conCreate();	
		try {
			String book_title=(req.getParameter("book_title"));
			PreparedStatement sta1=con.prepareStatement ("select *  from book where  book_title = ?");
			sta1.setString(1,book_title);
			ResultSet result=sta1.executeQuery();
			RequestDispatcher dis;
			PrintWriter out=res.getWriter();
			
				while(result.next())
				{
					String ISBN=result.getString(1);
					String booktitle=result.getString((2));
					out.println(ISBN+" "+booktitle);
					return;
					//dis=getServletContext().getRequestDispatcher("/WelcomeStudentServlet.html");
					//dis.forward(req,res);
					//out.println("Welcome "+ username);
		    	}
			
				dis=getServletContext().getRequestDispatcher("/check.html");
				dis.include(req,res);
				out.println("Wrong studentId or password");
			
		
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
   
}
