package library;
import java.io.IOException;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchByAuthorServlet
 */
public class SearchByAuthorServlet extends HttpServlet {
	
	Connection con;
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		
		MyConServlet mc=new MyConServlet();
		con= mc.conCreate();	
		try {
			String author_name=req.getParameter("author_name");
			PreparedStatement sta1=con.prepareStatement ("select * from book where  author_name =?");
			sta1.setString(1,author_name);
			ResultSet result=sta1.executeQuery();
			RequestDispatcher dis;
			PrintWriter out=res.getWriter();
//System.out.println("Autor name"+author_name);
			
				while(result.next())
				{
					//out.println("hi");
					String ISBN=result.getString(1);
					String booktitle=result.getString(2);
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
