
package sample2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.function.Consumer;
public class testproject 
{ 
  public static void main(String args[])
	  { 
	    String pro="";
		System.out.println("1.print names");
		System.out.println("2.alphabetical order");
		System.out.println("3.reverse order");
		System.out.println("4.for each anonymous class");
	try (Scanner str= new Scanner(System.in))
	{
		System.out.println("Enter your choice:");
	    pro=str.nextLine();
		System.out.println("your choice is:"+pro);
	}
	ArrayList<String> names= new ArrayList<String>();		
	names.add("sakthi");
	names.add("abi");
	names.add("prakash");
	names.add("saranya");
		if(pro.equalsIgnoreCase("1"))
		{
		System.out.print(names);
		}
        	
	   if(pro.equalsIgnoreCase("2"))
	    {
	     Collections.sort(names);
        System.out.println("\n Alphabetical order:"+names);
	    }
	   
	    if(pro.equalsIgnoreCase("3"))
	    {
         Collections.sort(names,Collections.reverseOrder());
         System.out.println("\n Reverse order:"+names);
	    }
        if(pro.equalsIgnoreCase("4"))	{
	    names.forEach(new Consumer<String>() {

			public void accept(String t) {
				System.out.println("\n"+t);
			}

		});
		
	  }
}
           
}