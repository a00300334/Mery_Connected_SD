package wk6_UDP_Excersise;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;


public class TC_FC_Client {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Temperature Converter Fahrenheit to Celsius: \n");
		System.out.print("Please enter temperature in farenheit: ");
		String user_input = sc.next();
		
		// 1. We need ip address from java.net.InetAddress class
		InetAddress ip = InetAddress.getByName("localhost");
		byte[] send_data = new byte[1024];
		
		// 2. Create Socket and encode string to byte
		DatagramSocket datagramSocket = new DatagramSocket();
		send_data = user_input.getBytes();
		
		// 3. Create datagramPacket and sent it trough datagram Socket
		DatagramPacket datagramPacket = new DatagramPacket(send_data, send_data.length, ip, 9877);
		datagramSocket.send(datagramPacket);
		
		// Receive datagramPacket
		byte[] reciveData = new byte[1024];
		DatagramPacket recivedDatagramPacket = new DatagramPacket(reciveData, reciveData.length);
		datagramSocket.receive(recivedDatagramPacket);
		
		String recivedData = new String(recivedDatagramPacket.getData());
		System.out.println(recivedData);
		datagramSocket.close();
	}

}
