package wk5;

import java.net.InetAddress;
import java.util.Scanner;

public class GetAllIpAdresses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		String hostname = "www.google.ie";
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter domain name: ");
		hostname = sc.next();
		
		try {
			InetAddress[] myHost = InetAddress.getAllByName(hostname);
			
			
			for(int x=0; x<myHost.length; x++) {
//				System.out.println( myHost[x].getHostAddress() );
			}
			
			int count = 0;
			for(InetAddress i : myHost) {
				count ++;
				System.out.println("ID "+ count + " : " + i.getHostAddress());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
