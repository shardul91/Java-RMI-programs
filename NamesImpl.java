import java.rmi.*;
import java.rmi.server.*;

public class NamesImpl extends UnicastRemoteObject implements NamesInterface {
	// Complete this class
	public NamesImpl() throws RemoteException {
		super();
	}
	public String addName(String firstName, String lastName) {
		if (Client.nameList.contains(firstName + " " + lastName)) {
			return ("\nYour name is already in the list.");
		} else {
			Client.nameList.add(firstName + " " + lastName);
			return ("\nI included your name.");
		}
	}
	public String removeName(String firstName, String lastName) {
		if (Client.nameList.contains(firstName + " " + lastName)) {
			Client.nameList.remove(firstName + " " + lastName);
			return ("\nYour name is removed from the list.");
		} else {
			return ("\nCouldn't find " + firstName + " " + lastName + " in the list.");
		}
	}
	public String listNames(String lastName) {
		String returnString = "";
		for (int i = 0; i < Client.nameList.size(); i++) {
			String fname, lname;
			fname = Client.nameList.get(i).substring(0, Client.nameList.get(i).indexOf(" "));
			lname = Client.nameList.get(i).substring((Client.nameList.get(i).indexOf(" ") + 1),
					Client.nameList.get(i).length());
			if (lname.equals(lastName)) {
				returnString += "\n"+Client.nameList.get(i);
			}
		}
		return returnString;
	}
}
