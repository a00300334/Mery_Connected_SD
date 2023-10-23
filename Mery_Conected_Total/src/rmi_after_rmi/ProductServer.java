package rmi_after_rmi;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import rmi.ProductInterface;

public class ProductServer extends ProductImpl{ 
	 
    public ProductServer(String aID, String aName, double price) {
		super(aID, aName, price);
	}

	public static void main(String [] args) {
	          try{ 
				    ProductImpl p00000011 = new ProductImpl ("p0000011","Banana", 0.35);  
				    ProductImpl p00000012 = new ProductImpl ("p0000012","Orange", 0.50);  
				    ProductImpl p00000013 = new ProductImpl ("p0000013","Apple", 0.45);  
				    
				    ProductInterface stub1 = (ProductInterface) UnicastRemoteObject.exportObject(p00000011 , 0);
				    ProductInterface stub2 = (ProductInterface) UnicastRemoteObject.exportObject(p00000012 , 0);
				    ProductInterface stub3 = (ProductInterface) UnicastRemoteObject.exportObject(p00000013 , 0);
					           
				    System.out.println( " Product ID: " + p00000011.getID() +" Name: " + p00000011.getName()+" Price :" + p00000011.getPrice() ); 
				    System.out.println( " Product ID: " + p00000012.getID() +" Name:" +  p00000012.getName()+" Price :" + p00000013.getPrice() ); 
				    System.out.println( " Product ID: " + p00000013.getID() +" Name: " + p00000013.getName()+" Price :" + p00000013.getPrice() ); 
  
				    Registry registry = LocateRegistry.createRegistry(1098);
				    registry.bind("rmi://products1", stub1);
				    registry.bind("rmi://products2", stub2);
				    registry.bind("rmi://products3", stub3);
				    
	          } catch (Exception e) {
	        	  	e.printStackTrace();
	          }
 }
}
