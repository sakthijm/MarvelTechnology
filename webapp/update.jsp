<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<%! String driverName = "com.mysql.jdbc.Driver";%>
<%!String url = "jdbc:mysql://localhost/Students";%>
<%!String user = "root";%>
<%!String psw = "";%>          
<% 
	String regno = request.getParameter("regno");
	String name =request.getParameter("name");
	String mark1=request.getParameter("mark1");
	String mark2=request.getParameter("mark2");
	String mark3=request.getParameter("mark3");

if(regno != null)
{
	PreparedStatement ps = null;
	int registerNumber= Integer.parseInt(regno);
try
{
	Class.forName("com.mysql.cj.jdbc.Driver");
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/students", "ruba", "marvel123");
    String sql="Update stumarks set name=?,mark1=?,mark2=?,mark3=?,total=? where regno="+regno;
	ps = conn.prepareStatement(sql);
	ps.setString(1, name);
	ps.setString(2, mark1);
	ps.setString(3, mark2);
	ps.setString(4, mark3);
	float Total = Float.parseFloat(mark1)+Float.parseFloat(mark2)+Float.parseFloat(mark3);
	ps.setFloat(5,Total);
	int i = ps.executeUpdate();
   if(i > 0)
  {
	String redirectURL = "http://localhost:8081/index";
	response.sendRedirect(redirectURL);
   }
   else
   {
    out.print("There is a problem in updating Record.");
   } 
 }

catch(SQLException sql)
  {
	request.setAttribute("error", sql);
	out.println(sql);
  }
}   
%>  

