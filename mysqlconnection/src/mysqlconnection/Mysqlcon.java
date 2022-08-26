package mysqlconnection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.lang.ClassNotFoundException;
import java.util.Scanner;
public class Mysqlcon
{
	public Mysqlcon() {
		try {
	//Load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
	//Establish connection to the MySQL database		
			getConnection();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	Connection conn ;
	
	
	/**
	 * Method to establish c1onnection to Mysql
	 * @return
	 * @throws SQLException
	 */
	public Connection getConnection() throws SQLException {
	conn = DriverManager.getConnection("jdbc:mysql://localhost/apartments","ruba","marvel123");
	return conn;
   	//Statement dp= conn.createStatement();  
	/*
	 * static String url= "jdbc:mysql://localhost/apartments"; static String
	 * username= "ruba";
	 */// static String password = "marvel123";
	}
	
	/**
	 * Main method of the application
	 * @param args
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static void main(String[] args)throws SQLException,ClassNotFoundException
	{
   	   
	    System.out.println("1.DISPLAY TABLE");
	    System.out.println("2.ROW INSERTION");
	    System.out.println("3.UPDATE ROW");
	    System.out.println("4.DELETE ROW");

	    Scanner choice = new Scanner(System.in);
		System.out.println("enter your choice\n");
		String option=choice.nextLine();
		System.out.println("your choice is\n"+option);
		 Mysqlcon sqlProgram =new Mysqlcon();
	    Connection connection = sqlProgram.getConnection();
	    sqlProgram.displayAll();
		sqlProgram.insert();
        sqlProgram.update();
        sqlProgram.delete();
	}
	 void displayAll()throws SQLException,ClassNotFoundException
	    {  
		 	
		 //Displaying all data in table
		     System.out.println("Display the table");
		 	 Statement st = conn.createStatement();
 			 ResultSet rs1 = st.executeQuery("select * from owner");
	        while(rs1.next())
	        {
	        	int flatno = rs1.getInt("flatno");
	 		    int blocknumber = rs1.getInt("blocknumber");
	            int floornumber = rs1.getInt("floornumber");
	            String name = rs1.getString("name");
	            int age = rs1.getInt("age");
	            String mobile = rs1.getString("mobile");
	            int residentcount = rs1.getInt("residentcount");
	            System.out.println( flatno + " "+ blocknumber+ " "+floornumber +" "+ name+" "+ age+" "+mobile+" "+residentcount );
	        }
	        rs1.close();
	        st.close();
	    } 
	 
	 
	    void insert() throws SQLException,ClassNotFoundException
	    {     
	    	Scanner inserting=new Scanner(System.in);
            System.out.println("do you want to insert..");
            String val=inserting.next();
	          if (val.equals("yes")) 
	          {
	        	          	  
	        	  System.out.println("TABLE INSERTION");
	        	  System.out.println("...............");
	        	  String insertSQL ="INSERT INTO owner values(7,8,9,'kumar',35,'9870654346',9)";
	        	  PreparedStatement st=conn.prepareStatement(insertSQL);
	        	  st.executeUpdate(insertSQL);
	        	  System.out.println("row inserted successfully!");
	 		      displayAll();
	 		       
	          }
	 		    
	          else if(val.equals("no")) {
	        	  System.out.println("thank you!");
	          }
	    }

           void update()throws SQLException,ClassNotFoundException
            { 
                       Scanner updating=new Scanner(System.in);
                       System.out.println("do you want to update..");
                       String rowupdate=updating.nextLine();
			      if (rowupdate.equals("yes"))	          
			     {
			        //table update
			    	  System.out.println("table updation");
			    	  System.out.println("..............");
		        	   String sqlt="Update owner set name=? where mobile=?";
		        	   PreparedStatement ps=conn.prepareStatement(sqlt);
			           ps.setString(1, "yyy");
					   ps.setString(2, "9884098840");
					   ps.executeUpdate();
					   displayAll();
					   System.out.println("table updated successfully!");
				  } 
		           else if(rowupdate.equals("no"))
		           {
		        	   System.out.println("thank you!");
		           }
             } 
			     	 
	  	void delete() throws SQLException,ClassNotFoundException
		{	     
			
			 Scanner deleteVariable =new Scanner(System.in);
		     System.out.println("Do you want to delete...");
		     String deletion = deleteVariable.nextLine();
	             if (deletion.equals("yes"))
			     {
			          String ruba="DELETE FROM owner where name='kumar'";
				 	  PreparedStatement st= conn.prepareStatement(ruba);
				 	  st.executeUpdate(ruba);
				 	  displayAll();
				 	  System.out.println("row deleteed successfully! ");
				 }
			     else if(deletion.equals("no")) 
			     {
			    	 System.out.println("thank you!");
			     }  
			
		    

            }
      }
	   

	

