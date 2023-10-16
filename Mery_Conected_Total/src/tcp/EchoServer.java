/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcp;
import java.io.*;
import java.net.*;

/**
 *
 * @author SRI-mpidgeon
 */
public class EchoServer {
    	public static void main(String[] args) {
    
        System.out.println("Echo Server IS RUNNING!");
		int portNumber = 1025;
                String clientInput;
		String clientReturn = "";
		
		try {

                    ServerSocket serverSocket = new ServerSocket(portNumber);
                    Socket clientSocket = serverSocket.accept();

                    // READ DATA RECEIVED FROM CLIENT
                    BufferedReader inputFromClient = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                                
                   // SEND RESULT TO SERVER
                    DataOutputStream sendToClient = new DataOutputStream(clientSocket.getOutputStream());
                    while ((clientInput =inputFromClient.readLine())!=null) {
                        sendToClient.writeBytes(clientInput);
                                    
                    }
           
		System.out.println("The text to send back is " + clientInput);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}