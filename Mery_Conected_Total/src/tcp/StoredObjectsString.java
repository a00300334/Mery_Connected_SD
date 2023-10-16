package tcp;
import java.rmi.RemoteException;

public class StoredObjectsString {

	   private String theKey;
	   private String theValue;

	   public StoredObjectsString() 
       {          
}
	    public StoredObjectsString(String aKey, String aValue) 
	                                {
	    	theKey=aKey;     
	    	theValue=aValue;            
	    }
	    

	// Implementation of the inherited (from UserInterface) method getName()
	    public String getKey(){
	        return theKey;
	    }
	 // Implementation of the inherited (from UserInterface) method getAccessLevel()
	    public String getValue(String aKey){
	        return theValue;
	    }

		// Implementation of the inherited (from UserInterface) method getName()
	    public void setKey(String aKey){
	        theKey=aKey;
	    }
	 // Implementation of the inherited (from UserInterface) method getAccessLevel()
	    public void setValue(String aValue){
	        theValue=aValue;
	    }
}
