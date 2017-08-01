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
 * Servlet implementation class EditBookServlet
 */
public class EditBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	Connection con;
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		MyConServlet mc=new MyConServlet();
		con= mc.conCreate();	
		try
		{
			int ISBN_no=Integer.parseInt(req.getParameter("ISBN_no"));
			int no_copies=Integer.parseInt(req.getParameter("No_copies"));
			String publication_year=req.getParameter("publication_year");	
			String publication_name=req.getParameter("publication_name");
			
			PreparedStatement sta1=con.prepareStatement ("select *  from book where  ISBN_no =?");
			sta1.setInt(1,ISBN_no);
			ResultSet result=sta1.executeQuery();
			RequestDispatcher dis;
			PrintWriter out=res.getWriter();
			if(result.next())
			{

				PreparedStatement sta2=con.prepareStatement ("update book set no_copies=?,publication_year=? ,publication_name=? where  ISBN_no =?");
				sta2.setInt(1,no_copies);
		
				sta2.setString(2,publication_year);
				sta2.setString(3,publication_name);
				sta2.setInt(4,ISBN_no);
				
				sta2.executeQuery();
				out.println("<script> alert (\"Books updated\")</script>");
				dis=getServletContext().getRequestDispatcher("/WelcomeLibrarian.jsp");
				dis.include(req,res);
				return;
					//dis=getServletContext().getRequestDispatcher("/WelcomeStudentServlet.html");
					//dis.forward(req,res);
					//out.println("Welcome "+ username);
		    }
			else
			{
				out.println("<script> alert (\"Book not found\")</script>");
				dis=getServletContext().getRequestDispatcher("/WelcomeLibrarian.jsp");
				dis.include(req,res);
			}
				
			
//				dis=getServletContext().getRequestDispatcher("/books.jsp");
//				dis.include(req,res);
//				out.println("Wrong Details");
	}
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    

}
