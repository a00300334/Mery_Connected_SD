/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcp;

/**
 *
 * @author SRI-mpidgeon
 */
import java.net.*;
import java.io.*;
 
public class TCPServer{
	public static void main(String[] args) {
		String clientInput;
		String clientReturn = "";
    	
        StoredObjectsString[] AbbrArray = new StoredObjectsString[2];
        AbbrArray[0]=new StoredObjectsString("ANSI","American National Standards Institute");
        AbbrArray[1]=new StoredObjectsString("API","Application Programming Interface");
    	
    	System.out.println("Server is Running!"); 	              
        int portNumber = 1025;
        	try {
            	ServerSocket serverSocket = new ServerSocket(portNumber);
				while(true){
			            Socket clientSocket = serverSocket.accept();                           
			            BufferedReader inputFromClient = new BufferedReader(
			            new InputStreamReader(clientSocket.getInputStream()));
			            clientInput = inputFromClient.readLine();
                                                         System.out.println("The text to send back is++ " + clientInput); 
			            clientInput.toUpperCase();
			            
			            for(int i=0;i<AbbrArray.length;i++){
							if(AbbrArray[i].getKey().equals(clientInput)){
								clientReturn=AbbrArray[i].getValue(clientInput);
							}
						}

						
                                              DataOutputStream sendToClient= new DataOutputStream(clientSocket.getOutputStream());
                                              sendToClient.writeBytes(clientReturn+"\n");
                                                
                                                System.out.println("Full text of "+clientInput+ "is: "+clientReturn);   
					}
				}catch (IOException e) {e.printStackTrace();
			}catch (Exception e) {e.printStackTrace();
		}
	}
}
