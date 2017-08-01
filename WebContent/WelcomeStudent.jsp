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
<body background="http://wallpapercave.com/wp/ijo8KeK.jpg">
<div>


<div>
<a href="Logout.jsp">Log out</a> 
 
<center><h1 style="font-size:300%"><font color="white">Student</h1></center>

<center>
<a href="books.jsp"> <font color="white">Search book</a>
<a href="availability.jsp"> <font color="white">Check availability</a>





  <a href="HistoryServlet"><font color="white">View history</a>  
</center>
  </div>

 

</body>
</html>