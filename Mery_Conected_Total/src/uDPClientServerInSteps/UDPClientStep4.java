package uDPClientServerInSteps;

import java.net.DatagramSocket;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

public class UDPClientStep4 {

	 
	public static void main(String args[]) throws Exception {
        System.out.println("UDP Client Started");
        // Initialise variables
        // Note "localhost" which is your own pc/laptop
		InetAddress IPAddress = InetAddress.getByName("localhost");
		byte[] sendData = new byte[1024];
		        
		/*Begin Change1 ====================================================================================== */  
		//    Step 4: Code changes            
		    byte[] receiveData = new byte[1024];
		/*End change1====================================================================================== */    
		  
        
        
        // Read data in from keyboard
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter a few words: ");
		String sentence= sc.nextLine();
		               
		        // Start the DatagramSocket for connecting to the server
		DatagramSocket clientSocket = new DatagramSocket();
		        // Convert the String to Bytes as the data in 
		        //the TCP/IP packet must be in Byte format
		sendData = sentence.getBytes();
		        // Create the Datagrame packet that you will send
		DatagramPacket sendPacket = new DatagramPacket(sendData,
				sendData.length, IPAddress, 9877);
		System.out.println("UDP Client Sending " + sendData);
		        // Send the data to the Server via the DatagramSocket created earlier 
		clientSocket.send(sendPacket);
        
        
        
/*Begin Change2 ====================================================================================== */  
//    Step 4: Code changes
//   Receive  the capitalised sentence back from the server

        // As the data is received in byte format, you need 
        //to convert it to String format so that you can read it
		         // Create the DatagramPacket to receive the data from the server
		DatagramPacket receivePacket = new DatagramPacket(receiveData,receiveData.length);
		        // Receive the data via the DatagramSocket created earlier 
		clientSocket.receive(receivePacket);
		        // As the data is received in byte format, you need 
		        //to convert it to String format so that you can read it
		String modifiedSentence = new String(receivePacket.getData());
		        //Print the modified sentence in easy to read String format
		System.out.println("UDP Client Received From Server:" + modifiedSentence);            
		/*End Change2======================================================================================  */
		
		       
		        // Close the socket when done
		clientSocket.close();
		}
}
