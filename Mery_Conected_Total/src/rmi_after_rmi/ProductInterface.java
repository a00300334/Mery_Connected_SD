package rmi_after_rmi;

import java.rmi.Remote;

interface ProductInterface extends Remote{
	
	 public String getName();
	 public String getID();
	 public double getPrice();
	 public void setName(String aName);
	 public void setID(String aID);
	 public void setPrice(double aPrice);
	 
}
