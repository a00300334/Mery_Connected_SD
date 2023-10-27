package rmi_question_2;

class User implements UserInterface{ 
	   private String theAccessLevel; 
	   private String theName; 
	   public User (String theAccessLevel, String aName) 
	   { 
	        this.theAccessLevel = theAccessLevel; 
	        this.theName = aName;
	   } 
	   public String getAccessLevel() 
	   { 
	        return theAccessLevel; 
	   } 
	   public String getName() 
	   { 
	        return theName; 
	   }
		@Override
		public void setAccessLevel(String s) {
			this.setAccessLevel(s);
			
		}
		@Override
		public void setName(String s) {
			this.setName(s);
			
		} 
	   
	   
	 } 
