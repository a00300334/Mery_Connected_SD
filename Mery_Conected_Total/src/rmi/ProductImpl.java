package rmi;

import java.rmi.RemoteException;

public class ProductImpl implements ProductInterface{

	private String theDescription;
	
	public ProductImpl(String desc) {
		theDescription = desc;
	}
	
	@Override
	public String getDescription() throws RemoteException {
		return theDescription;
	}

}
