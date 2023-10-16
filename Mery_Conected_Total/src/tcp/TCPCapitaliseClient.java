/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcp;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 *
 * @author SRI-mpidgeon
 */
public class TCPCapitaliseClient {
	
	public static void main(String[] args) {	
		try {		
			Socket clientSocket = new Socket("localhost", 1025);
                        // Hard Code data to send to server
                        String textToSendToServer = "Hello";

                        // Uncomment the following 3 lines to READ DATA TO SEND TO SERVER IN FROM SCREEN
//			System.out.println("Enter any text : ");        
//			BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
//			String textToSendToServer = inFromUser.readLine();

			// SEND DATA TO SERVER
			DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
			outToServer.writeBytes(textToSendToServer+"\n");       
                        // Print Text send to Server
                        System.out.println("Text sent to server is: " + textToSendToServer);			
                        // RECEIVE DATA BACK FROM SERVER
			BufferedReader inputFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			// PRINT RECEIVED DATA TO SCREEN
			System.out.println("Text echoed back from server is : " + inputFromServer.readLine());
                        
                        	         

			clientSocket.close();                     
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}