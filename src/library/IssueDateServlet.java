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
 * Servlet implementation class IssueDateServlet
 */
public class IssueDateServlet extends HttpServlet {
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
		PreparedStatement sta1=con.prepareStatement ("select *  from borrowed");
		ResultSet result1=sta1.executeQuery();
		RequestDispatcher dis;
		PrintWriter out=res.getWriter();
		ArrayList<borrowedClass> list=new ArrayList<borrowedClass>();
		while(result1.next())
		{
			borrowedClass borrowed=new borrowedClass();
			borrowed.setIsbnNo(result1.getInt(2));
			borrowed.setDate(result1.getString(3));
			list.add(borrowed);
		}
		if(!list.isEmpty())
		{
			getServletContext().setAttribute("borrowedList",list);
			dis=getServletContext().getRequestDispatcher("/ViewBorrowedL.jsp");
			dis.forward(req, res);
		}
		else
		{
		out.println("<script> alert (\"No book issued\")</script>");
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
