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
 * Servlet implementation class SignUpServlet
 */
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	Connection con;
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		MyConServlet mc=new MyConServlet();
		con= mc.conCreate();	
		try {
			int Student_Id=Integer.parseInt(req.getParameter("Student_Id"));
			 String Student_Name=req.getParameter("Student_Name");
			 String Sex=req.getParameter("Sex");
			 String Date_of_Birth=(req.getParameter("Date_of_Birth"));
			 String contact_Number=req.getParameter("contact_Number");	
			 String password=req.getParameter("password");
			
			PreparedStatement sta1=con.prepareStatement ("select *  from Student_Details where  Student_Id =?");
			sta1.setInt(1,Student_Id);
			ResultSet result=sta1.executeQuery();
			RequestDispatcher dis;
			PrintWriter out=res.getWriter();
			if(result.next())
			{
				out.println("<script> alert (\"User with Student Id already exists\")</script>");
				dis=getServletContext().getRequestDispatcher("/login.jsp");
				dis.include(req,res);
		    }
			else
			{
				PreparedStatement sta3=con.prepareStatement ("Insert into Student_Details values(?,?,?,?,?,?)");
				sta3.setInt(1,Student_Id);
				sta3.setString(2,Student_Name);
				sta3.setString(3,Sex);
				sta3.setString(4,Date_of_Birth);
				sta3.setString(5,contact_Number);
				sta3.setString(6,password);
				sta3.executeQuery();
				out.println("<script> alert (\"Signed up successfully\")</script>");
				dis=getServletContext().getRequestDispatcher("/login.jsp");
				dis.include(req,res);
				return;
			}
	}
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    

}
