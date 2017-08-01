package library;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class IssueBookServlet
 */
public class IssueBookServlet extends HttpServlet {
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
			int Student_id=Integer.parseInt(req.getParameter("student_id"));
			PreparedStatement sta1=con.prepareStatement ("select *  from book where  ISBN_no =?");
			sta1.setInt(1,ISBN_no);
			ResultSet result=sta1.executeQuery();
			RequestDispatcher dis;
			PrintWriter out=res.getWriter();
			System.out.println("Reacher issueServlet");
			if(result.next())
			{
				int avail_copies=result.getInt(5);
				if(avail_copies>0)
				{
					avail_copies--;
					PreparedStatement sta2=con.prepareStatement ("update book set available_copies=? where  ISBN_no =?");
					sta2.setInt(1,avail_copies);
					sta2.setInt(2,ISBN_no);
					sta2.executeQuery();
					
					PreparedStatement sta3=con.prepareStatement ("insert into borrowed values(?,?,?,?)");
					sta3.setInt(1,Student_id);
					sta3.setInt(2,ISBN_no);
					
					String dateString = null;
					   SimpleDateFormat sdfr = new SimpleDateFormat("dd/MMM/yyyy");
					   /*you can also use DateFormat reference instead of SimpleDateFormat 
					    * like this: DateFormat df = new SimpleDateFormat("dd/MMM/yyyy");
					    */
					   try
					   {
						   Date date=new Date();
						   dateString = sdfr.format(date);
						   sta3.setString(4,dateString);
					   }
					   catch (Exception ex ){
						System.out.println(ex);
					   }
					   SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy");
					   Calendar c = Calendar.getInstance();
					   c.setTime(new Date()); // Now use today date.
					   c.add(Calendar.DATE, 15); // Adding 5 days
					   String output = sdf.format(c.getTime());
					   sta3.setString(3, output);
					  // System.out.println(output);
			
			
					
					sta3.executeQuery();
					out.println("<script> alert (\"Book issued\")</script>");
					dis=getServletContext().getRequestDispatcher("/WelcomeLibrarian.jsp");
					dis.include(req,res);
					return;
					
				}
				else
				{
					out.println("<script> alert (\"Book not available\")</script>");
					dis=getServletContext().getRequestDispatcher("/WelcomeLibrarian.jsp");
					dis.include(req,res);
				}

				
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
