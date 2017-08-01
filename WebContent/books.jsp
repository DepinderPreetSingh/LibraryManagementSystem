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
<body background="http://abrasaparvaz.com/wp-content/uploads/2016/06/yV5GB.jpg">
<div>


<center><h1 style="font-size:300%"><font color="white">Books</h1></center>
<h2> Search by</h2>
<form action="/LibraryManagementSystem/SearchServlet" method= "post">
<select name ="searchBy">
  <option value="author_name">AUTHOR</option>
<option value="publication_name">PUBLISHER</option>
<option value="book_title">TITLE</option>


 </select>





  <div class="container">
    <label><b>Deatils</b></label>
    <input type="text" placeholder="Enter Details" name="details" required><br>

    
        
    <button type="submit">Submit</button>
    
  </div>

  <div class="container" style="background-color:#f1f1f1">
    
</form>

</body>
</html>