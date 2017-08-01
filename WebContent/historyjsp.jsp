<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page session="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
<%
	int y= (Integer)(request.getAttribute("id"));
//int x=Integer.parseInt(str);
out.println("id is"+y);
%>
	<%-- <jsp:forward page="Welcome.jsp"/> --%>
	<jsp:forward page="/HistoryServlet">
	<jsp:param name="user" value="<%=y %>" />
	</jsp:forward> 

</body>
</html>