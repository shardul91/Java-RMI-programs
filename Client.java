import java.util.*;
import java.io.IOException;
import java.rmi.*;

public class Client {
	public static ArrayList<String> nameList = new ArrayList<>();
	public static void main(String[] args) 
    throws NotBoundException, IOException {
    String registryURL = "rmi://localhost:1234/names";
    NamesInterface h = (NamesInterface)Naming.lookup(registryURL);    
    Scanner keyboard = new Scanner(System.in);
    while(true){
      //Complete this while-loop
      System.out.print("1 to add a name, 2 to remove a name, 3 to list the names, or 4 to terminate: ");
      int choice = keyboard.nextInt();                      
      if(choice==1) {
    	  System.out.println("Enter your first name: ");
          String firstName = keyboard.next();
          System.out.println("Enter your last name: ");
          String lastName = keyboard.next();
          System.out.println(h.addName(firstName, lastName));  
      	}
      else if(choice==2){
    	  System.out.println("Enter your first name: ");
          String firstName = keyboard.next();
          System.out.println("Enter your last name: ");
          String lastName = keyboard.next();    	  
    	  System.out.println(h.removeName(firstName, lastName));
      }
      else if(choice == 3) {
          System.out.println("Enter your last name: ");
          String lastName = keyboard.next();
    	  System.out.println(h.listNames(lastName));  
      }
      else if (choice == 4){
    	  System.out.println("Terminating program");
    	  System.exit(0);
      }
      else {
    	  System.err.println("Invalid input. Please enter 1-4!");
    	  System.exit(0);
      }
     }    
    }
  }
