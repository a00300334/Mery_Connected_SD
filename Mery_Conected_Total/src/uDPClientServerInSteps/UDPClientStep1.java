package uDPClientServerInSteps;

/**
 *
 * @author marypidgeon
 */

import java.io.*;
import java.net.*;
import java.util.*;

class UDPClientStep1 {
	public static void main(String args[]) throws Exception {
                System.out.println("UDP Client Started");
		InetAddress IPAddress = InetAddress.getByName("localhost");
		byte[] sendData = new byte[1024];
                
                // Hardcoded data to send
		String sentence = "Hello Server"; 
                
                
		// Convert the String to Bytes as the data in 
                //the TCP/IP packet must be in Byte format
		sendData = sentence.getBytes();

                // Create the Datagram packet that you will send
		DatagramPacket sendPacket = new DatagramPacket(sendData,
				sendData.length, IPAddress, 9878);


                // Start the DatagramSocket for connecting to the server
		DatagramSocket clientSocket = new DatagramSocket();
		System.out.println("UDP Client Sending " + sendData);
                // Send the data via the DatagramSocket created earlier 
		clientSocket.send(sendPacket);
                
                // Close the socket when done
		clientSocket.close();
	}
}
