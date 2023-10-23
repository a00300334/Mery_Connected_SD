package rmi_after_rmi;

public class ProductImpl implements ProductInterface{
	   private String theID; 
	   private String theName; 
	   private double thePrice;
	   
	   public ProductImpl (String aID, String aName, double price) 
	   { 
        theID = aID; 
        theName = aName; 
        thePrice = price;
	   } 
	
	public String getName() 
	   { 
	        return theName; 
	   } 
	   public String getID() 
	   { 
	        return theID; 
	   } 
	   public double getPrice() 
	   { 
	        return thePrice; 
	   } 
	   public void setName(String aName) 
	   { 
	        theName=aName; 
	   } 

	   public void setID(String aID) 
	   { 
	        theID=aID; 

	  } 
	   public void setPrice(double aPrice) 
	   { 
	        thePrice=aPrice; 
	   } 

}
