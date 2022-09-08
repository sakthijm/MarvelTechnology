<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="java.sql.*" %>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<% 

     Connection con=null;
     Statement st=null;
     ResultSet rs=null;
     String regno = request.getParameter("regno");
     int register=Integer.parseInt(regno);
     try
     {
    	Class.forName("com.mysql.cj.jdbc.Driver");
 		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/students", "ruba", "marvel123");
 	    st=conn.createStatement();
 		String sql="select*from stumarks where regno="+register;
 		rs=st.executeQuery(sql);
 		while(rs.next())
 		{
 			out.print("REGNO:"+rs.getString(1)+
 					"name:"+rs.getString(2)+
 					"mark1:"+rs.getString(3)+ 
 					"mark2:"+rs.getString(4)+
 					"mark3:"+rs.getString(5)+
 					"total:"+rs.getString(6));
 		}
     }
     catch(Exception e){}
     %>
     <form action="/update.jsp" method="POST">
       <br><br> <label for="regno">Register number:</label> <input type="text"
			name="regno" id="regno" /><br>
		<br> <label for="name">Name:</label> <input type="text"
			name="name" id="name" /><br>
		<br> <label for="mark1">Mark1:</label> <input type="text"
			name="mark1" id="mark1" /><br>
		<br> <label for="mark2">Mark2:</label> <input type="text"
			name="mark2" id="mark2" /><br>
		<br> <label for="mark3">Mark3:</label> <input type="text"
			name="mark3" id="mark3" /><br>
		<br> <input type="submit" value="Submit">
		</form>
     </body>
     </html>