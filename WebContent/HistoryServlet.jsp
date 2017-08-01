<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%

			MyConServlet mc=new MyConServlet();
			PrintWriter out=response.getWriter();
			out.println("HI GGGGGGGGGGGGGGGGGG");
			int id=(Integer)(request.getAttribute("id"));
			
			con= mc.conCreate();
			out.println("HI ");
			try {
				
				PreparedStatement sta1;
				sta1 = con.prepareStatement ("select *  from borrowed where  student_id =?");
				sta1.setInt(1,id);
				ResultSet result=sta1.executeQuery();
				while(result.next())
				{
					int student_id=result.getInt(1);
					int Isbn=result.getInt(2);
					String due_date=result.getString(3);
					out.println(student_id+" "+Isbn+" "+due_date);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}





%>



</body>
</html>