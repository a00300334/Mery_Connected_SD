package wk5;

import java.net.InetSocketAddress;
import java.net.Socket;

public class PortScanner {


	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		for(int port =1; port <=1000; port++) {
			try {
				Socket socket = new Socket();
				socket.connect(new InetSocketAddress("localhost", port));
				System.out.println("Port " + port + " is open. \n");
				socket.close();
				
			}catch(Exception e) {
//				System.out.println("Port " + port + " is closed. \n");
			}
		}
		
	}

}
