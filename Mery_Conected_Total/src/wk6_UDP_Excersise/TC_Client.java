package wk6_UDP_Excersise;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class TC_Client {

	public static void main(String[] args) throws Exception{
		// The following is an example of the output of the UDP client server application: 
		// Client: Please enter a temperature Celsius value:  22.2 
		//  Server: Converting 22.2 Celsius to Fahrenheit: The result is 71.96 
		//	Client: 22.2 degrees Celsius = 71.96 degrees Fahrenheit. 

		System.out.println("UPD Client to sent celcius and get farenheit started \n");
		
		//1. We need ip address
		InetAddress ip = InetAddress.getByName("localhost");
		byte[] sendData = new byte[1024];
		
		// We need a data to enter
		System.out.println("Please enter a temperature Celsius value: ");
		Scanner sc = new Scanner(System.in);
		String text = sc.next();
		double value = Double.parseDouble(text);
		
		
		
		// Create Datagram Socket
		DatagramSocket dg = new DatagramSocket();
		
		//Convert string to bytes
		sendData = text.getBytes();
		
		// Prepare Datagram Packet
		DatagramPacket dp = new DatagramPacket(sendData, sendData.length, ip, 9877);
		System.out.println("Sending data: " + sendData);
		
		//Send the data trough datagram socket
		dg.send(dp);
		
		//-----------------------------------------------------
		
		// Received Datagram packet
		byte[] reciveData = new byte[1024];
		DatagramPacket reciver_dp = new DatagramPacket(reciveData, reciveData.length);
		
		// Check recived Datagram
		dg.receive(reciver_dp);
		String recived_String = new String(reciver_dp.getData());
		dg.close();
		
	}

}
