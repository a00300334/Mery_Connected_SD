package uDPClientServerInSteps;

/**
 *
 * @author marypidgeon
 */
import java.io.*;
import java.net.*;
import java.util.*;

class UDPClientStep2and3 {
	public static void main(String args[]) throws Exception {
                System.out.println("UDP Client Started");
		InetAddress IPAddress = InetAddress.getByName("localhost");
		byte[] sendData = new byte[1024];

                
                                
  /*====================================================================================== */  
  //    Step 2: Code changes
                //Replace the following line so that you can read input from the keyboard
                // OLD code. Comment out or delete the following line
		//String sentence = "Hello Server"; 
                // NEW code to read input from the keyboard
                Scanner sc = new Scanner(System.in);
		System.out.println("Please enter a few words: ");
		String sentence= sc.nextLine();
                
 /*======================================================================================  */

                   
                // Start the DatagramSocket for connecting to the server
		DatagramSocket clientSocket = new DatagramSocket();
                // Convert the String to Bytes as the data in 
                //the TCP/IP packet must be in Byte format
		sendData = sentence.getBytes();
                // Create the Datagrame packet that you will send
		DatagramPacket sendPacket = new DatagramPacket(sendData,
				sendData.length, IPAddress, 9878);
		System.out.println("UDP Client Sending " + sendData);
                // Send the data via the DatagramSocket created earlier 
		clientSocket.send(sendPacket);
                
                // Close the socket when done
		clientSocket.close();
	}
}
