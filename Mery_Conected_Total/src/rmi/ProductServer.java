package rmi;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ProductServer extends ProductImpl{

	public ProductServer(String description) {
		super(description);
	}
	
	public static void main(String[] args) {
		System.out.println("Server is running..");
		try {
			ProductImpl obj = new ProductImpl("This is a car");
			ProductInterface stub = (ProductInterface) UnicastRemoteObject.exportObject(obj, 0);
			
			Registry registry = LocateRegistry.createRegistry(1098);
			registry.bind("rmi://car", stub);
			
		}catch(Exception e) {
			System.out.println("Server exception: " + e.toString());
			e.printStackTrace();
		}

	}

}
