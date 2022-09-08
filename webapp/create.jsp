<%@ page language="java" contentType="text/html; charset=ISO-8859-1"     pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*,java.util.*"%>
<%
String regno=request.getParameter("regno");
String name=request.getParameter("name");
String mark1=request.getParameter("mark1");
String mark2=request.getParameter("mark2");
String mark3=request.getParameter("mark3");
String total=request.getParameter("total");
	try
	{
	    Class.forName("com.mysql.cj.jdbc.Driver");
	    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/students", "ruba", "marvel123");
	    float Total = Float.parseFloat(mark1)+Float.parseFloat(mark2)+Float.parseFloat(mark3);
	    Statement st=conn.createStatement();
	    int i = st.executeUpdate("insert into stumarks(regno,name,mark1,mark2,mark3,total)values('"+regno+"','"+name+"','"+mark1+"','"+mark2+"','"+mark3+"','"+Total+"')");
	    String redirectURL = "http://localhost:8081/index";
	    response.sendRedirect(redirectURL);
	   
	}
	catch(Exception e)
	{
	     System.out.print(e);
	     e.printStackTrace();
	}
	
 %>