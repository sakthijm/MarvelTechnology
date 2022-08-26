package Marksheet;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Marksheet {
	
	public	Marksheet()
	{
		
		try {
				Class.forName("com.mysql.cj.jdbc.Driver");		
				getConnection();
			}
		    catch (ClassNotFoundException e)
		    {
		    	e.printStackTrace();
    		}
            catch(SQLException e) {
            	
            	e.printStackTrace();
            }

		     catch(IOException e) {
         	
         	   e.printStackTrace();
         }
}

    	Connection stu;
    	public Connection getConnection() throws SQLException,IOException
    	{
    		stu= DriverManager.getConnection("jdbc:mysql://localhost/students","ruba","marvel123");
    		return stu;
    	}
    	 public static void main(String args[])throws ClassNotFoundException, IOException, SQLException  
    	 {
    			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    			System.out.println("enter your choice:");
    			String option=input.readLine();
				Records obj =new Records();
				//object creation
				if( option.equals("1"))
				{
					obj.displayAll();
				}		
				else if( option.equals("2"))
				{
					obj.insertTable();
				}		
				else if( option.equals("3"))
			    {
					obj.deleteTable();
	    		}
			
		     }
    		    void display() 
    		    {
    		    	try
    		    	{
    				System.out.println("1.Display table");
    				System.out.println("2.Table insertion");
    				System.out.println("4.table updation");
    				System.out.println("5.table deletion");
    				BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        			System.out.println("enter your choice:");
        			String option=input.readLine();
        			System.out.println("your choice is:"+option);
    		    	
    		    }
    		    	catch(IOException e)
    		    	{
    		    		e.printStackTrace();
    		    	}
    		    }  	
    }
    		    

    class Records extends Marksheet 
    {
    	void displayAll()throws SQLException,IOException
    	{  	System.out.println("display the table");
    	    System.out.println(".................");
    		Statement stmt = stu.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM stumarks");
               while (rs.next()) {
               int regno = rs.getInt("regno");
               String name = rs.getString("name");
               int mark1 = rs.getInt("mark1");
               int mark2= rs.getInt("mark2");
               int mark3 = rs.getInt("mark3");
               System.out.println(regno+"   "+name+"    "+mark1+"  "+mark2+" "+mark3);
               
               }
               display();
    	} 
    	void insertTable()throws IOException, SQLException
    	{
    		    
    		    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
				System.out.print("\nEnter your regno:");
				String regno = input.readLine();
				System.out.print("\nRegister number: "+regno+ "\n");
				System.out.print("\nEnter your name:");
				String Name = input.readLine();
				System.out.print("\nName:"+Name+"\n" );
				System.out.print("\nEnter your mark1:");
				String Mark1 = input.readLine();
				System.out.print("\nmark1:"+Mark1+ "\n");
				System.out.print("\nEnter your mark2:");
				String Mark2 = input.readLine();
				System.out.print("\nmark2:"+Mark2+ "\n");
				System.out.print("\nEnter your mark3:");
				String Mark3 = input.readLine();
				System.out.print("\nmark3:"+Mark3+ "\n");
				float total = Float.parseFloat(Mark1)+Float.parseFloat(Mark2)+Float.parseFloat(Mark3);
				Statement st = stu.createStatement();
				st.executeUpdate("INSERT INTO stumarks(regno,name,mark1,mark2,mark3, total) VALUES("+regno+",'"+Name+"',"+Mark1+","+Mark2+","+Mark3+","+total+")"); 
				displayAll();
				System.out.println("row inserted successfully!");
				
			
    	}
		void deleteTable() throws IOException, SQLException{
    		System.out.println("TABLE DELETION");
			System.out.println("...............");
			System.out.println("enter regno to delete 1 row ");
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    		String regno = in.readLine();
    		System.out.println("delete the row where regno is :"+regno);
			Statement st= stu.createStatement();
			String delete="DELETE FROM stumarks where regno=103";
			st.executeUpdate(delete);
			displayAll();
			display();
    	}    
    
    	 }
