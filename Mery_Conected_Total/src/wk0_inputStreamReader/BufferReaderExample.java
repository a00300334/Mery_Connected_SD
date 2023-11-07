package wk0_inputStreamReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BufferReaderExample {

	
	
	public static void main(String[] args) {
		// Different method of capturing data from the user
		System.out.println("Example of using BufferReader");
		
		// The same achieved with scanner
		//		Scanner sc = new Scanner(System.in)	;
		//		String a = sc.next();
		//		System.out.println(a);
			
		BufferedReader inputFromServer = new BufferedReader(new InputStreamReader(System.in));
		try {
			String data = inputFromServer.readLine();
			System.out.println(data);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
				
	}

}
