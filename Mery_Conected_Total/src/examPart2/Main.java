package examPart2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		// We prompt the user to enter the site name that he want to read
		System.out.println("Input the domain name of the page you would like to read: ");
		
		// We need to instantiate an Scanner object to read the data using System.in way.
		Scanner in = new Scanner(System.in);
		String page = in.next();
		
		try {
			
			// Now we need create new URL object
			URL url = new URL(page);
			
			// Open the stream to the object 
			InputStream stream = url.openStream();
			
			// And create a new BufferedReader object which allows us to read the page 
			BufferedReader r = new BufferedReader(new InputStreamReader(stream));
			
			// Here we are looking line by line to see if something exist at that line and
			// program will does it until there will be nothing more left.
			String line;
			while (  (line = r.readLine()) != null) {
				System.out.println(line);
			}
			
			
		} catch (MalformedURLException e) {
			System.out.println("Error MalformedURLException found....");
			System.out.println(e.getMessage());
			e.printStackTrace();
			
		} catch (IOException e) {
			System.out.println("Error IOException found....");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		

	}

}
