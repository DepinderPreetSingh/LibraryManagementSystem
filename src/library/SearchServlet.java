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
 * Servlet implementation class SearchByTitleServlet
 */
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Connection con;
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		
		MyConServlet mc=new MyConServlet();
		con= mc.conCreate();	
		try {
			String searchBy=req.getParameter("searchBy");
			
			if(searchBy.equals("book_title"))
			{
			String book_title=(req.getParameter("details"));
			PreparedStatement sta1=con.prepareStatement ("select *  from book where  book_title = ?");
			sta1.setString(1,book_title);
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
					dis=getServletContext().getRequestDispatcher("/ViewBook.jsp");
					dis.forward(req, res);
				}
				else
				{
				out.println("<script> alert (\"No book found\")</script>");
				dis=getServletContext().getRequestDispatcher("/books.jsp");
				dis.include(req,res);
				}
			}
			else if(searchBy.equals("publication_name"))
			{
				String publication_name=(req.getParameter("details"));
				PreparedStatement sta1=con.prepareStatement ("select *  from book where  publication_name =?");
				sta1.setString(1,publication_name);
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
				if(!list.isEmpty())
				{
					getServletContext().setAttribute("bookList",list);
					dis=getServletContext().getRequestDispatcher("/ViewBook.jsp");
					dis.forward(req, res);
				}
				else
				{
				out.println("<script> alert (\"No book found\")</script>");
				dis=getServletContext().getRequestDispatcher("/books.jsp");
				dis.include(req,res);
				}
			}
			else if(searchBy.equals("author_name"))
			{
				String author_name=req.getParameter("details");
				PreparedStatement sta1=con.prepareStatement ("select * from book where  author_name =?");
				sta1.setString(1,author_name);
				ResultSet result=sta1.executeQuery();
				RequestDispatcher dis;
				PrintWriter out=res.getWriter();
	//System.out.println("Autor name"+author_name);
				
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
				if(!list.isEmpty())
				{
					getServletContext().setAttribute("bookList",list);
					dis=getServletContext().getRequestDispatcher("/ViewBook.jsp");
					dis.forward(req, res);
				}
				else
				{
				out.println("<script> alert (\"No book found\")</script>");
				dis=getServletContext().getRequestDispatcher("/books.jsp");
				dis.include(req,res);
				}
		
		}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
   
}
