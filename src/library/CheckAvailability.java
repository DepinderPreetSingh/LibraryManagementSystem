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
 * Servlet implementation class CheckAvailability
 */
public class CheckAvailability extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	Connection con;
    public CheckAvailability() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		MyConServlet mc=new MyConServlet();
		con= mc.conCreate();	
		try {
			//System.out.println("hicdcfa");
			String ISBN_no=(req.getParameter("ISBN_no"));
			PreparedStatement sta1=con.prepareStatement ("select *  from book where  ISBN_no =?");
			sta1.setString(1,ISBN_no);
			ResultSet result=sta1.executeQuery();
			RequestDispatcher dis;
			PrintWriter out=res.getWriter();
			if(result.next())
			{
				//System.out.println("hicdcfa2");
				int Available_Copies=result.getInt(5);
				if(Available_Copies>0)
				{
					out.println("<script> alert (\"BOOK IS AVAILABLE \")</script>");
					dis=getServletContext().getRequestDispatcher("/WelcomeStudent.jsp");
					dis.include(req,res);
				}
				else
				{
					sta1=con.prepareStatement("select * from Borrowed  where Isbn_no=?");
					sta1.setString(1,ISBN_no);
					ResultSet result1=sta1.executeQuery();
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
						dis=getServletContext().getRequestDispatcher("/ViewBorrowed.jsp");
						dis.forward(req, res);
					}
					else
					{
					out.println("<script> alert (\"No book borrowed\")</script>");
					dis=getServletContext().getRequestDispatcher("/WelcomeStudent.jsp");
					dis.include(req,res);
					}
				}
				
				return;
					//dis=getServletContext().getRequestDispatcher("/WelcomeStudentServlet.html");
					//dis.forward(req,res);
					//out.println("Welcome "+ username);
		   	}
			out.println("<script> alert (\"INCORRECT ISBN\")</script>");
			dis=getServletContext().getRequestDispatcher("/WelcomeStudent.jsp");
			dis.include(req,res);
			
		
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
