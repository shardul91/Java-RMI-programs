import java.rmi.Remote;
import java.rmi.RemoteException;
public interface NamesInterface extends Remote{
public String addName(String firstName, String lastName) throws RemoteException;
public String removeName(String firstName, String lastName)throws RemoteException;
public String listNames(String lastName)throws RemoteException;
}