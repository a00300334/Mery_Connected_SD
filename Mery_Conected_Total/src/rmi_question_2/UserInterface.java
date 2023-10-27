package rmi_question_2;

import java.rmi.Remote;
import java.rmi.RemoteException;

interface UserInterface extends Remote{
	 public String getAccessLevel() throws RemoteException;
	 public String getName() throws RemoteException;;
	 public void setAccessLevel(String s) throws RemoteException;;
	 public void setName(String s) throws RemoteException;
	 
}
