package wk6_UDP_Excersise;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class TC_Server {

	 public static void main(String args[]) throws Exception {
	        try{
	            // Initialise Variables
	            int serverPort = 9877;
	            DatagramSocket serverSocket = new DatagramSocket(serverPort);
	            System.out.println("UDP Server: Started on port: "+ serverPort);
	            // the data is byte format which is the format of data within the TCP/IP data packet   
	            byte[] receiveData = new byte[1024];
	            
	   /*Begin Change1 ====================================================================================== */  
	  //    Step 4: Code changes            
	            byte[] sendData = new byte[1024];
	   /*End change1====================================================================================== */    
	          
	            while (true) {  // listen forever
	                System.out.println("UDP Server: Waiting for Data on port: "+serverPort);
	                // Create the DatagramPacket to receive the data from the client
	                DatagramPacket receivePacket = new DatagramPacket(receiveData,
	                        receiveData.length);
	                // Receive the data via the DatagramSocket created earlier 
	                serverSocket.receive(receivePacket);
	                System.out.println("UDP server Received in impossible to read byte format " + receivePacket);
	                // As the data is received in byte format, you need 
	                //to convert it to String format so that you can read it
	                String sentence = new String(receivePacket.getData());
	                
	                double data = Double.parseDouble(sentence);
//	                data = data*9/5-32;
	                data = ((data*9)/5)+32;
	                
	               System.out.println("UDP server Received in easy to read format: " + sentence);
	               System.out.println("UDP server has taken: " + data);
	               
	               String capitalizedSentence = ""+data;
	               

	 
	    /*Begin Change2 ====================================================================================== */  
	  //    Step 4: Code changes
	  //   Send the capitalised sentence back to the client
	                // get the ipaddress and port of the client from the packet received earlier
	                InetAddress IPAddress = receivePacket.getAddress();
			        int clientPort = receivePacket.getPort();
		                // convert the capitalised sentence to Bytes which is the format needed in the Datagram Packet
			        sendData = capitalizedSentence.getBytes();
		                // Print information to the server screen
		                //Create the DatagramPackage 
			        DatagramPacket sendPacket = new DatagramPacket(sendData,sendData.length, IPAddress, clientPort);
	                //send the data in the serverSocket created earlier
		            serverSocket.send(sendPacket);
	                System.out.println("UDP Server Sending to Client at IPAddress: " + IPAddress + " port: "+clientPort);		
	                System.out.println("The converted text capitalised: " + capitalizedSentence);
	  /*End change2====================================================================================== */    
	       
	            }
	        } catch (SocketException s){
	            s.printStackTrace();
	        }
	    }
	    
		public static String setUppercaseString(String sentence){
		
		    String ans = sentence.toUpperCase();
		    return ans;
		
		    }
		}
