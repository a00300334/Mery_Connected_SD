package tcp;

import java.io.*;
	import java.net.*;
import java.util.Scanner;
	 
	public class TCPClient {
	    public static void main(String[] args) {
	    	System.out.println("Client is Running.....");
	        try {    		   		 
	        	Socket clientSocket=new Socket("localhost",1025);
	     
	        	System.out.println("Please enter an abbreviatsion hint API: ");
	        	Scanner sc = new Scanner(System.in);
	        	
//	        	BufferedReader inFromUser = new BufferedReader( new InputStreamReader(System.in));
//	        	String letter =inFromUser.readLine();
	        	String letter = sc.nextLine();
	                   
	        	DataOutputStream outToServer= new DataOutputStream(clientSocket.getOutputStream());
	            outToServer.writeBytes(letter+"\n");
	           
	            BufferedReader inputFromClient = new BufferedReader(
		        new InputStreamReader(clientSocket.getInputStream()));
	       
	            System.out.println("The full text equivalent of "+letter+" is: "+inputFromClient.readLine());
                    clientSocket.close();
	            
	            
	         } catch (IOException e) {
	            e.printStackTrace();
	        } catch (Exception e) {
	           e.printStackTrace();
	        } 
	    }
	}

