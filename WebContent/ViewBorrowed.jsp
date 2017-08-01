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
ArrayList<borrowedClass> list =new ArrayList<borrowedClass>();
list=(ArrayList)application.getAttribute("borrowedList");
System.out.println("List is "+list);
%>
<div>
<body style="background-color:#A55D35;">
<div>

 <a href="WelcomeStudent.jsp">Home</a>
<center><h1 style="font-size:300%"><font color="black">Issued Books</h1></center>

<table>
<tr>
	<th><font color="black"><b>ISBN no </b></th>
	<th><font color="black"><b>Due date </b></th>
	</tr>
<% 
for(borrowedClass b:list)
{
%>
<tr>
	<td><font color="black"><%=b.getIsbnNo() %></td>
	<td><font color="black"><%=b.getDate() %></td>
	</tr>
<%
}
%>
</table>
</body>
</html>
