package rmi_question_2;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class UserServer{
	
	
//	public UserServer(String theAccessLevel, String aName) {
//		super(theAccessLevel, aName);
//		// TODO Auto-generated constructor stub
//	}

	public static void main(String[] args) {
		User one = new User("1", "Something");
		User two = new User("2", "Something");
		User three = new User("3", "Something");
		
		try {
			UserInterface stub1 = (UserInterface) UnicastRemoteObject.exportObject(one, 0);
			UserInterface stub2 = (UserInterface) UnicastRemoteObject.exportObject(two, 0);
			UserInterface stub3 = (UserInterface) UnicastRemoteObject.exportObject(three, 0);
			
			System.out.println( stub1.getAccessLevel() + "  " + stub1.getName());
			System.out.println( stub2.getAccessLevel() + "  " + stub2.getName());
			System.out.println( stub3.getAccessLevel() + "  " + stub3.getName());
			
			Registry registry = LocateRegistry.createRegistry(1098);
			registry.bind("rmi:///st", stub1);
			registry.bind("rmi:///st1", stub2);
			registry.bind("rmi:///st2", stub3);

		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AlreadyBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
