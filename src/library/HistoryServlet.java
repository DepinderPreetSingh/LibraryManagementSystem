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
 * Servlet implementation class HistoryServlet
 */
public class HistoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HistoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    Connection con;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		MyConServlet mc=new MyConServlet();
		PrintWriter out=response.getWriter();
		String s=(String)getServletContext().getAttribute("pp");
		int id=Integer.parseInt(s);
		//System.out.println("value coming here"+s);
		con= mc.conCreate();
		try {
			
			PreparedStatement sta1;
			sta1 = con.prepareStatement ("select *  from borrowed where  student_id =?");
			sta1.setInt(1,id);
			ResultSet result1=sta1.executeQuery();
			RequestDispatcher dis;
			//PrintWriter out=res.getWriter();
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
				dis.forward(request, response);
			}
			else
			{
			out.println("<script> alert (\"No book borrowed\")</script>");
			dis=getServletContext().getRequestDispatcher("/WelcomeStudent.jsp");
			dis.include(request,response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}

}
