package wk5;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class IpAddressOfHostName {

	public static void main(String[] args) {
		
		String hostname = "www.rte.ie";
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter domain name: ");
		hostname = sc.next();
		
		try {
			InetAddress ipaddress = InetAddress.getByName(hostname);
			System.out.println("Ip adress of " + hostname + " is " + ipaddress.getHostAddress());
		}catch(UnknownHostException e) {
			System.out.println("We can't find the host...");
			e.printStackTrace();
		
		}
		
	}

}
