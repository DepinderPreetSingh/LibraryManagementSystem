<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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

<div>
<body background="http://www.softeny.com/1/2015/07/natural-brown-modern-library-cabinet-that-can-be-decor-with-wooden-floor-can-add-th-beauty-inside-the-modern-house-design-ideas-with-modern-lighting-inside-940x742.jpg">
<div>


<div>
<a href="Logout.jsp">Log out</a> 
 
<center><h1 style="font-size:300%"><font color="black">Librarian</h1></center>

<center>
  <a href="add.jsp"> <font color="white">Add book</a>
<a href="edit.jsp"><font color="white"> Edit book</a>
  <a href="delete.jsp"> <font color="white"> Delete book</a>  
<a href="issue.jsp"><font color="white"> Issue book</a>
  <a href="IssueDateServlet"><font color="white"> Due date of books</a>
<a href="CollectionServlet"><font color="white"> Collection</a> 
 
</center>
  </div>

 


</div>
</body></html>



</body>
</html>