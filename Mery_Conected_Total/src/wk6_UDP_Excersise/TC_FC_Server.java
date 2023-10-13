package wk6_UDP_Excersise;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class TC_FC_Server {

	public static void main(String[] args) throws Exception {

		DatagramSocket serverSocket = new DatagramSocket(9877);
		
		byte[] recivedData = new byte[1024];
		byte[] sendData = new byte[1024];
		
		while(true) {
			DatagramPacket datagramPacket = new DatagramPacket(recivedData, recivedData.length);
			serverSocket.receive(datagramPacket);
			String str = new String(datagramPacket.getData());
			
			String returnString = farenheitToCelcius(str);
			
			InetAddress ip = datagramPacket.getAddress();
			int clientPort = datagramPacket.getPort();
			sendData = returnString.getBytes();
			DatagramPacket sendPacket = new DatagramPacket(sendData,sendData.length,ip,clientPort);
			serverSocket.send(sendPacket);
		}
	}

	public static String farenheitToCelcius(String farenheit) {
		double f = Double.parseDouble(farenheit);
		f = ((f-32)*5)/9;
		String out = String.format("%.2f", f);
		return "" + out;
	}
}

