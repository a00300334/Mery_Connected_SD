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
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author SRI-mpidgeon
 */
public class TCPCapitaliseServer {
    	public static void main(String[] args) {
    
        System.out.println("Echo Server IS RUNNING!");
		int portNumber = 1025;
                String clientInput;
		String clientReturn = "";
	
		try {

	        ServerSocket serverSocket = new ServerSocket(portNumber);

                        System.out.println("The text to send back is ");
                    while(true){
                        Socket clientSocket = serverSocket.accept();
                         System.out.println("The text to send back is========= ");
                    // READ DATA RECEIVED FROM CLIENT
                    BufferedReader inputFromClient = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                                           //   System.out.println("The text to send back is++ " + inputFromClient.readLine());                          
                     clientInput = inputFromClient.readLine();
                     System.out.println("The text to send back is++ " + clientInput);     
                     clientReturn=clientInput.toUpperCase();
                     
                  //   System.out.println("The text to send back is " + clientReturn);
                           
                    
                   // SEND RESULT TO SERVER
                    DataOutputStream sendToClient = new DataOutputStream(clientSocket.getOutputStream());

                        sendToClient.writeBytes(clientReturn+"\n");
                                   
                                                                 
                                   
		System.out.println("The text to send back is " + clientReturn);
                
                    }  
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}