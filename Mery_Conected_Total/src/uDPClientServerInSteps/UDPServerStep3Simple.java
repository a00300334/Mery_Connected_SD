package uDPClientServerInSteps;
/**
 *
 * @author marypidgeon
 */
import java.net.*;

public class UDPServerStep3Simple {
    
    public static void main(String args[]) throws Exception {
        try{
            // Initialise Variables
            int serverPort = 9878;
            DatagramSocket serverSocket = new DatagramSocket(serverPort);
            System.out.println("UDP Server: Started on port: "+serverPort);
            // the data is byte format which is the format of data within the TCP/IP data packet   
            byte[] receiveData = new byte[1024];
            while (true) {  // listen forever
                System.out.println("UDP Server: Waiting for Data on port: "+serverPort);;
                // Create the Packet
                DatagramPacket receivePacket = new DatagramPacket(receiveData,
                        receiveData.length);
                // Receive the data via the DatagramSocket created earlier 
                serverSocket.receive(receivePacket);
                System.out.println("UDP server Received in impossible to read byte format " + receivePacket);
                // As the data is received in byte format, you need 
                //to convert it to String format so that you can read it
                String sentence = new String(receivePacket.getData());
                System.out.println("UDP server Received in easy to read format: " + sentence);
                
   /*Begin Change ====================================================================================== */  
  //    Step 3: Code changes
             // In this example, the text received is converted to Uppercase text and output to screen
                
                          
               String capitalizedSentence= sentence.toUpperCase();
               System.out.println("UDP server has converted the string to upper case in easy to read format: " + capitalizedSentence);
               
 /*End change====================================================================================== */    
                
            }
        } catch (SocketException s){
            s.printStackTrace();
        }
    }
    
}
