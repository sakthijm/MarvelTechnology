<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>
<!DOCTYPE html>
<html>
	<head>
	 <title>CRUD</title>
	</head>
	<body>
		<sql:setDataSource var = "demo" driver = "com.mysql.cj.jdbc.Driver" url = "jdbc:mysql://localhost/students"  user = "ruba" password = "marvel123"/>

		<sql:query dataSource = "${demo}" var = "result">
         SELECT * from stumarks;
		</sql:query>
    
      
		<button onclick="createFunction()">CREATE</button>
		<button onclick="readFunction()">READ</button>
		<button onclick="updateFunction()">UPDATE</button>
		<button onclick="deleteFunction()">DELETE</button>
		<div id="readTable" style="display:none">
		<table border="1" >
	        <thead>
	         <tr>
	               
		            <th style="color:blue;">Register Number</th>
		            <th style="color:blue;">Name</th>
		            <th style="color:blue;">Mark 1</th>
		            <th style="color:blue;">Mark 2</th>
		            <th style="color:blue;">Mark 3</th>
		            <th style="color:blue;">Total</th>
		          
		         </tr>
	         </thead>
	         <tbody>
		         <c:forEach var = "row" items = "${result.rows}">
		            <tr>
		               <td><c:out value = "${row.regno}"/></td>
		               <td><c:out value = "${row.name}"/></td>
		               <td><c:out value = "${row.mark1}"/></td>
		               <td><c:out value = "${row.mark2}"/></td>
		               <td><c:out value = "${row.mark3}"/></td>
		               <td><c:out value = "${row.total}"/></td>
		            </tr>
		         </c:forEach> 
	         </tbody>    
		</table>
		</div>
		<div id="createTable"> 
			 <form action="/create.jsp" method="POST">
		      <label for="regno">Register number:</label>
		      <input type="text" id="regno" name="regno"><br><br>
		      <label for="name">Name:</label>
		      <input type="text" id="name" name="name"><br><br>
		      <label for="mark1">Mark1:</label>
		      <input type="text" id="mark1" name="mark1"><br><br>
		      <label for="mark2">Mark2:</label>
		      <input type="text" id="mark2" name="mark2"><br><br>
		      <label for="mark3">Mark3:</label>
		      <input type="text" id="mark3" name="mark3"><br><br>
		      <input type="submit" value="Submit">
			</form>
		</div>
	  <div id="deleteTable" style="display:none"> 
			 <form action="/delete.jsp" method="POST">
		      <label for="regno">Register number:</label>
		      <input type="text" id="regno" name="regno"><br><br>
		      <input type="submit" value="Submit">
		     </form>
		     </div>
	
  <div id="updateTable" style="display:none"> 
        <form action="/update.jsp" method="POST">
       <label for="regno">Register number:</label>
      <input type="text" id="regno" name="regno"><br><br>
      <input type="submit" value="Submit">
</form>
</div>
            
<script>
      var create = document.getElementById("createTable");
      var deleterow = document.getElementById("deleteTable");
      var update = document.getElementById("updateTable");
      var read = document.getElementById("readTable");
           function createFunction()
            {
    	   if(create.style.display=="none")
    		   {
	    		   create.style.display="block";
		   		   deleterow.style.display="none";
		   		   update.style.display="none";
		   		   read.style.display="none";
    		   }
            }
           function deleteFunction()
           {
   	      if(deleterow.style.display=="none")
   		   {
   		   create.style.display="none";
   		   deleterow.style.display="block";
   		   update.style.display="none";
   		   read.style.display="none";
   		   }
           }
           function updateFunction()
           {
	   	       if(update.style.display=="none")
	   		   {
		   		   create.style.display="none";
		   		   deleterow.style.display="none";
		   		   update.style.display="block";
		   		   read.style.display="none";
	   		   }
           }
           function readFunction()
           {
	   	       if(read.style.display=="none")
		   		   {
		   		   create.style.display="none";
		   		   deleterow.style.display="none";
		   		   update.style.display="none";
		   		   read.style.display="block";
	   		   }
           }
		</script>
	</body>
</html>