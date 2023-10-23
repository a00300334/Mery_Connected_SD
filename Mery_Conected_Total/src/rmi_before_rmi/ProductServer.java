package rmi_before_rmi;

class Product{ 
	   private String theID; 
	   private String theName; 
	   private double thePrice;
	   public Product (String aID, String aName, double price) 
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
	 
 public class ProductServer{ 
	 
    public static void main(String [] args) 
	          { 
    Product p00000011 = new Product ("p0000011","Banana", 0.35);  
	Product p00000012 = new Product ("p0000012","Orange", 0.50);  
	Product p00000013 = new Product ("p0000013","Apple", 0.45);  
	           
    System.out.println( " Product ID: " + p00000011.getID() +" Name: " + p00000011.getName()+" Price :" + p00000011.getPrice() ); 
    System.out.println( " Product ID: " + p00000012.getID() +" Name:" +  p00000012.getName()+" Price :" + p00000013.getPrice() ); 
    System.out.println( " Product ID: " + p00000013.getID() +" Name: " + p00000013.getName()+" Price :" + p00000013.getPrice() ); 
   } 
 }

