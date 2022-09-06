<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import="java.sql.*,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>update table</title>
</head>
<body>
<%
	String regno=request.getParameter("regno");
	Class.forName("com.mysql.cj.jdbc.Driver");
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/students", "ruba", "marvel123");
    Statement st=conn.createStatement();
    int up=st.executeUpdate("update stumarks set name='sathya', mark1=50,mark2=50,mark3=50 WHERE regno="+regno);
    String redirectURL = "http://localhost:8081/index";
    response.sendRedirect(redirectURL);
   
	
 %>

</body>
</html>