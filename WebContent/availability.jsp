<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page session="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>



button {
    background-color:#441500 ;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 10%;
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
<body>

<div>

<body background="http://wallpapercave.com/wp/ID5VL9t.jpg">
<div>



<div>
<form action="/LibraryManagementSystem/CheckAvailability" method="post" >

<center><h1 style="font-size:300%"><font color="white">Availability check</h1></center>
<div>
    <label><b>Details</b></label>
    <input type="text" placeholder="Enter Isbn no" name="ISBN_no">

    <BR>
        
    <button type="submit">Submit</button>
    
  </div>

  <div style="background-color:#f1f1f1">
    
</div></form>

</div>
</body>
</html>