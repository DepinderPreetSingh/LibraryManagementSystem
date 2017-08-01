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
<%
String name = (String)session.getAttribute("name");
if ((name != null && !name.equals(""))) 
{;}
else
{response.sendRedirect("login.jsp");
session.invalidate();}%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div>
<body background="http://wallpapercave.com/wp/Q84CnST.jpg">
<div>
<div>


<center><h1 style="font-size:300%"><font color="white">Delete</h1></center>

<form action="/LibraryManagementSystem/DeleteBookServlet" method="post">
<div>


<table>
<tr>
<td><font color="white"><b>ISBN no: </b></font></td>
<td><input type="text" name="ISBN_no"></td>
</tr>

<td><input type="submit" value="Delete"></td>

</table>


</div>
</div>

</div>
</form>
</body>
</html>