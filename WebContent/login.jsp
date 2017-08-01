<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>
form {
    border: 3px solid #f1f1f1;
}

input[type=text], input[type=password] {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;
}

button {
    background-color: #420f0b;
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
.cancelbtn {
    width: auto;
    padding: 10px 18px;
    background-color: #f44336;
}

.imgcontainer {
    text-align: center;
    margin: 24px 0 12px 0;
}

img.avatar {
    width: 40%;
    border-radius: 50%;
}

.container {
    padding: 16px;
}

span.psw {
    float: right;
    padding-top: 16px;
}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
    span.psw {
       display: block;
       float: none;
    }
    .cancelbtn {
       width: 100%;
    }
}
</style>
<body>


<center><h1 style="font-size:300%;">Library</h1></center>
<h2> <font color="white">Login as</h2>
<form action="/LibraryManagementSystem/Login" method="post">
<select name="user" >
  <option value="Student">Student</option>
  <option value="Librarian">Librarian</option>
 </select>
  <div>
<body background="http://hdwallpaperbackgrounds.net/wp-content/uploads/2015/10/Excellent-Home-Library-Study-Room-Wallpaper-HD.jpg">
<div>

  <div class="imgcontainer">
    <img src="avatar.png" alt="Avatar" class="avatar">
  </div>


  <div class="container">
    <label><b><font color="white">UserID</b></label>
    
    <input type="text" placeholder="Enter User ID" name="id" required/>

    <label><b><font color="white">Password</b></label>
    <input type="password" placeholder="Enter Password" name="password" /><br>
        
    <button type="submit">Login</button><br>
    <a href="signup.jsp">Sign Up</a>     
    
   
  </div>

  <div class="container" style="background-color:"white">
    
</form>

</body>
</html>