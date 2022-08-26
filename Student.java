package studentsdetails;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.Statement;

class Student 
{

	public Student ()
	{
		try {
				Class.forName("com.mysql.cj.jdbc.Driver");		
				getConnection();
			}
		    catch (ClassNotFoundException e)
		    {
		    	e.printStackTrace();
		    }
		    	catch (SQLException e) 
		    {
		    	e.printStackTrace();
		    }
	}  
	Connection stu;
	public Connection getConnection() throws SQLException
	{
		stu= DriverManager.getConnection("jdbc:mysql://localhost/students","ruba","marvel123");
		return stu;
	}
	    
	
	void display() {
		System.out.println("1.Display table");
		System.out.println("2.Table insertion");
		System.out.println("3.table alteration");
		System.out.println("4.table updation");
		System.out.println("5.table deletion");
		try 
		{
			try (Scanner input = new Scanner(System.in)) {
				System.out.println("Enter your choice:");
				String option= input.nextLine();
				System.out.println(" your choice is:"+option);
				Records obj =new Records();
				//object creation
				if(option=="1"){
					obj.displayAll();
				}
				if(option=="2"){
					obj.insertTable();
				}
				else if(option=="3")
				{
					obj.alterTable();
				}
				else if(option=="4"){
					obj.updateTable();
				}
				else if(option=="5"){
					obj.deleteTable();
				}
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
			     
}
	 
class Records extends Student 
{
	void displayAll()throws SQLException
	{  	
		//Displaying all data in table
		display();
		try (Scanner input = new Scanner(System.in)) {
			System.out.println("Enter your choice:");
			String option= input.nextLine();
			System.out.println(" your choice is:"+option);
		}
		System.out.println("Display the table");
		Statement st = stu.createStatement();
		ResultSet rs1 = st.executeQuery("select * from stumarks");
		while(rs1.next())
		{
			int regno = rs1.getInt("regno");
			String name= rs1.getString("name");
			int mark1 = rs1.getInt("mark1");
			int mark2 = rs1.getInt("mark2");
			int mark3 = rs1.getInt("mark3");
			System.out.println( regno + " "+ name+ " "+mark1 +" "+ mark2+" "+ mark3);
		}
		rs1.close();
		st.close();
	} 
	 
	void insertTable() throws SQLException{
		display();
		try (Scanner input = new Scanner(System.in)) {
			System.out.println("Enter your choice:");
			String option= input.nextLine();
			System.out.println(" your choice is:"+option);
		}
		System.out.println("TABLE INSERTION");
		System.out.println("...............");
		
		    try (Scanner Regno = new Scanner(System.in)) {
				System.out.print("Enter your regno: ");
				String regno = Regno.nextLine();
				System.out.print("regno"+regno);
				try (Scanner name = new Scanner(System.in)) {
					System.out.print("Enter your name");
					String Name = name.nextLine();
					System.out.print("Name"+Name);
				}
				try (Scanner Mark1 = new Scanner(System.in)) {
					String mark1 = Mark1 .nextLine();
					System.out.print("Enter your mark1 ");
					System.out.print("mark1"+mark1);
				}
				try (Scanner Mark2 = new Scanner(System.in)) {
					System.out.print("Enter your mark2 ");
					String mark2 = Mark2.nextLine();
					System.out.print("mark2:"+mark2);
				}
				try (Scanner Mark3 = new Scanner(System.in)) {
					System.out.print("Enter your mark3");
					String mark3 = Mark3.nextLine();
					System.out.print("mark3:"+mark3);
				}
			    }
		
		String input = "INSERT INTO stumarks"+ " (Regno,Name,mMark1,Mark2,Mark3)"+"values=?,?,?,?,?";
		Statement st=stu.createStatement();
		st.executeUpdate(input);
		System.out.println("row inserted successfully!");
		st.close();
	}
		
	void alterTable() 
	{
		try {
			display();
			try (Scanner input = new Scanner(System.in)) {
				System.out.println("Enter your choice:");
				String option= input.nextLine();
				System.out.println(" your choice is:"+option);
			}
			System.out.println("TABLE ALTERATION");
			System.out.println("...............");
			String alter = "ALTER TABLE stumarks "+ "ADD COLUMN total FLOAT not NULL," + "ADD COLUMN result VARCHAR(20)";
			Statement stmt = stu.createStatement();
			stmt.executeUpdate(alter);
			stmt.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	void updateTable() 
	{
		try {
			display();
			try (Scanner input = new Scanner(System.in)) {
				System.out.println("Enter your choice:");
				String option= input.nextLine();
				System.out.println(" your choice is:"+option);
			}
			System.out.println("TABLE UPDATION");
			System.out.println("...............");
			String update ="Update stumarks set total=m1+m2+m3"+"Update stumarks set result='pass' where m1>39 and m2>39 and m3>39";
			Statement updating = stu.createStatement();
			updating.executeUpdate(update);
			updating.close();
		} 
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	void deleteTable(){
		try {	
			display();
			try (Scanner input = new Scanner(System.in)) {
				System.out.println("Enter your choice:");
				String option= input.nextLine();
				System.out.println(" your choice is:"+option);
			}
			System.out.println("TABLE DELETION");
			System.out.println("...............");
			try (Scanner deleterow = new Scanner(System.in)) {
				System.out.println("enter regno to delete 1 row ");
				String regno = deleterow.nextLine();
				String delete ="Delete stumarks "+"("+regno+")";
				Statement st= stu.createStatement();
				st.executeUpdate(delete);
				st.close();
			}
		} 
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	class test{
		public void main (String[] args)throws SQLException
		{
			try {
			Records obj=new Records();
			obj.displayAll();
			obj.insertTable();
			obj.updateTable();
			obj.alterTable();
			obj.deleteTable();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			
		}
	}
}


     


