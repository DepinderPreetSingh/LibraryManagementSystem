<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page session="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
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
<div>

<body background="http://wallpapercave.com/wp/IlpLRYK.jpg">
<div>


<center><h1 style="font-size:300%"><font color="white">Add</h1></center>

<form action="/LibraryManagementSystem/AddBookSevlet" method="post">

<table>
<tr>
<td><font color="white"><b>ISBN no: </b></font></td>
<td><input type="text" name="ISBN_no" value=15></td>
</tr>
<tr>
<td><font color="white"><b>Book Title: </b></font></td>
<td><input type="text" name="Book_Title" value="chemistry"></td>
</tr>
<tr>
<td><font color="white"><b>Author Name: </b></font></td>
<td><input type="text" name="author_name" value="Kheamni"></td>
</tr>
<tr>
<td><font color="white"><b>Publisher: </b></font></td>
<td><input type="text" name="publication_name" value="sspring"></td>
</tr>
<tr>
<td><font color="white"><b>Publish year: </b></font></td>
<td><input type="text" name="publication_year" value="2009"></td>
</tr>
<tr>
<td><font color="white"><b>Quantity: </b></font></td>
<td><input type="number" name="No_copies" value=12></td>
</tr>

<td></td>
<td><input type="submit" value="Add"></td>

</table>

</form>
</div>
</div>

</div>
</body>
</html>