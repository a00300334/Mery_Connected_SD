package mqtt;

public class Rooms {
	
	private double temp;

	private static int id;
	
	Rooms(){
		
		
	}
	
	Rooms(double temp){
		this.temp=temp;

		
		id++;
	}
	
	public double getTemp(){
		return temp;
	}

	public void setTemp(double temp){
		this.temp=temp;
	}

	
	public int getId(){
		return id;
	}
}
