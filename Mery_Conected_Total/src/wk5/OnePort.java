package wk5;

import java.net.InetSocketAddress;
import java.net.Socket;

public class OnePort {


	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
			int port = 9876;
			
			try {
				Socket socket = new Socket();
				socket.connect(new InetSocketAddress("localhost", port));
				System.out.println("Port " + port + " is open. \n");
				socket.close();
				
			}catch(Exception e) {
				System.out.println("Port " + port + " is closed. \n");
			}
		}
		
}

