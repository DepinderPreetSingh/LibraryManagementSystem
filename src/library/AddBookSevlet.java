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
 * Servlet implementation class AddBookSevlet
 */
public class AddBookSevlet extends HttpServlet {
	Connection con;
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		MyConServlet mc=new MyConServlet();
		con= mc.conCreate();	
		try {
			int ISBN_no=Integer.parseInt(req.getParameter("ISBN_no"));
			 String book_title=req.getParameter("Book_Title");
			 String author_name=req.getParameter("author_name");
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
				int new_no_copies=result.getInt(4)+no_copies;
				int new_avail_copies=result.getInt(5)+no_copies;
				PreparedStatement sta2=con.prepareStatement ("update book set no_copies=? , available_copies=? where  ISBN_no =?");
				sta2.setInt(1,new_no_copies);
				sta2.setInt(2,new_avail_copies);
				sta2.setInt(3, ISBN_no);
				sta2.executeQuery();
				

				//out.println("Books added");
				out.println("<script> alert (\"Books added\")</script>");
				dis=getServletContext().getRequestDispatcher("/WelcomeLibrarian.jsp");
				dis.include(req,res);
					//out.println("Welcome "+ username);
		    }
			else
			{
				float price = 1000f;
				PreparedStatement sta3=con.prepareStatement ("Insert into book values(?,?,?,?,?,?,?,?)");
				sta3.setInt(1,ISBN_no);
				sta3.setString(2,book_title);
				sta3.setString(3,author_name);
				sta3.setInt(4,no_copies);
				sta3.setInt(5,no_copies);
				sta3.setFloat(6, price);
				sta3.setString(7,publication_year);
				sta3.setString(8,publication_name);
				sta3.executeQuery();
				out.println("<script> alert (\"New Book added\")</script>");
				dis=getServletContext().getRequestDispatcher("/WelcomeLibrarian.jsp");
				dis.include(req,res);
				return;
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
