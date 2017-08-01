<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*,library.*"%>
     <%@ page session="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
table, th, td {
    border: 1px solid black;
    border-collapse: collapse;
}
th, td {
    padding: 5px;
}
th {
    text-align: left;
}
a {
    background-color: #420f0b;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;                                 
    border: none;
    cursor: pointer;
    width: 20%;
}

a:hover {                       
    opacity: 0.8;
}
</style>
<%
String name = (String)session.getAttribute("name");
if ((name != null && !name.equals(""))) 
{;}
else
{response.sendRedirect("login.jsp");
session.invalidate();}%>
<body>
<% 
ArrayList<bookClass> list =new ArrayList<bookClass>();
list=(ArrayList)application.getAttribute("bookList");
System.out.println("List is "+list);
%>
 <a href="WelcomeLibrarian.jsp">Home</a>
<div>
<body style="background-color:#A55D35;">
<div>
<center><h1 style="font-size:300%"><font color="black">Books</h1></center>

<table>
<tr>
	<th><font color="black"><b>ISBN no</b></th>
	<th><font color="black"><b>Book Title</b></th>
	<th><font color="black"><b>Author Name</b>
</th>
	<th><font color="black"><b>Publisher </b>

</th>
	<th><font color="black"><b>Publish year</b>

</th>
	</tr>

<% 
for(bookClass b:list)
{
%>
 <tr>
    <td><%=b.getIsbnNo() %></td>
    <td><%=b.getBookTitle() %></td>
    <td><%=b.getAuthorName() %></td>
 <td><%=b.getPublicationName() %></td>
<td><%=b.getPublicationYear() %></td>

  </tr>
<%
}
%>
</table>


</body>
</html>