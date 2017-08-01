<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page session="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>



button {
    background-color:#4CAF50 ;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 100%;
}

button:hover {
    opacity: 0.8;
}


</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<%
String name = (String)session.getAttribute("name");
if ((name != null && !name.equals(""))) 
{;}
else
{response.sendRedirect("login.jsp");
session.invalidate();}%>
<body>
<div>
<body background="http://starchop.altervista.org/wp-content/uploads/2015/02/Famous-Library-HD-Wallpaper.jpg">
<div>
<div>



<center><h1 style="font-size:300%"><font color="black">Issue book</h1></center>

<form action="/LibraryManagementSystem/IssueBookServlet" method="post">

<div>


<table>
<tr>
<td><font color="black"><b>ISBN no: </b></font></td>
<td><input type="text" name="ISBN_no"></td>
</tr>
<tr>
<td><font color="black"><b>Student Id: </b></font></td>
<td><input type="text" name="student_id"></td>
</tr>



<td></td>
<td><input type="submit" value="Issue"></td>

</table>


</div>
</div>

</div>
</form>
</body>

</html>