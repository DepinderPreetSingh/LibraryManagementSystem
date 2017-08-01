<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page session="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
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



.container {
    padding: 16px;
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
<form action="/LibraryManagementSystem/SignUpServlet" method="post">
<div>

<body background="http://wallpapercave.com/wp/IlpLRYK.jpg">
<div>


<center><h1 style="font-size:300%"><font color="white">New User</h1></center>


<form action="/LibraryManagementSystem/SignUpServlet" method="post">
<table>
<tr>
<td><font color="white"><b>User id: </b></font></td>
<td><input type="text" name="Student_Id"></td>
</tr>
<tr>
<td><font color="white"><b>Enter name: </b></font></td>
<td><input type="text" name="Student_Name"></td>
</tr>
<tr>
<td><font color="white"><b>Gender: </b></font></td>
<td><input type="text" name="Sex" ></td>
</tr>
<tr>
<td><font color="white"><b>Date of birth: </b></font></td>
<td><input type="text" name="Date_of_Birth" ></td>
</tr>
<tr>
<td><font color="white"><b>Contact No.: </b></font></td>
<td><input type="text" name="contact_Number" ></td>
</tr>
<tr>
<td><font color="white"><b>Enter password: </b></font></td>
<td><input type="password" name="password" ></td>
</tr>

<td></td>
<td><input type="submit" value="Sign up"></td>

</table>


</div>
</div>

</div>
</form>
</body></html>