package library;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CollectionServlet
 */
public class CollectionServlet extends HttpServlet {
	Connection con;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	MyConServlet mc=new MyConServlet();
	con= mc.conCreate();	
	try
	{
		PreparedStatement sta1=con.prepareStatement ("select * from book");
		ResultSet result=sta1.executeQuery();
		RequestDispatcher dis;
		PrintWriter out=res.getWriter();
		ArrayList<bookClass> list=new ArrayList<bookClass>();
		while(result.next())
		{
			bookClass book=new bookClass();
			book.setIsbnNo(result.getInt(1));
			book.setBookTitle(result.getString(2));
			book.setAuthorName(result.getString(3));
			book.setNoCopies(result.getInt(4));
			book.setAvailableCopies(result.getInt(5));
			book.setPrice(result.getFloat(6));
			book.setPublicationYear(result.getString(7));
			book.setPublicationName(result.getString(8));
			
			list.add(book);
			
    	}
		//System.out.println("ji");
		if(!list.isEmpty())
		{
			getServletContext().setAttribute("bookList",list);
			dis=getServletContext().getRequestDispatcher("/ViewBookLib.jsp");
			dis.forward(req, res);
		}
		else
		{
		out.println("<script> alert (\"No book found\")</script>");
		dis=getServletContext().getRequestDispatcher("/WelcomeLibrarian.jsp");
		dis.include(req,res);
		}
		
//			dis=getServletContext().getRequestDispatcher("/books.jsp");
//			dis.include(req,res);
//			out.println("Wrong Details");
}
	catch (SQLException e) 
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
