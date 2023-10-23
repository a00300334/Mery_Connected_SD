package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ProductInterface extends Remote{
	public String getDescription() throws RemoteException;
}
