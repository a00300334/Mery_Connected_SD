package mqtt;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;

class MqttSubscriberJava implements MqttCallback { //implements MqttCallback {
        
    public static void main(String[] args){
      String topic = "currentTemp";

	  //Note: Change the topic to 
	  // include your studentID so that your topic does not clash with someone else in the class
      // String topic = "room1/sensehat/temp";
      // Change the ipaddress to the domain name or IPaddress  of the broker you are using
        //String broker = "tcp://localhost:1883";
        String broker = "tcp://192.168.1.100:1883";
        String clientId = "Java Subscriber";

        try {
            MqttClient sampleClient = new MqttClient(broker, clientId);
            MqttConnectOptions connOpts = new MqttConnectOptions();
            connOpts.setCleanSession(true);
            System.out.println("Connecting to broker: " + broker);
            sampleClient.connect(connOpts);
            System.out.println("Connected1");
            sampleClient.subscribe(topic, 1);
            System.out.println("Waiting for a publish from somewhere ");
            sampleClient.setCallback(new MqttSubscriberJava());
            try {
                Thread.sleep(10000);
               
               // sampleClient.disconnect();
            } catch(Exception e) {
                e.printStackTrace();
            }
           // System.out.println("Disconnected");
           // System.exit(0);
        } catch(MqttException e){
            e.printStackTrace();
        }
    }
    
    // The first of the three Interface MqttCallback's methods that must be included
    // Called when the client lost the connection to the broker
    // we can override it with our own functionality but for now we do nothing
    
   public void connectionLost(Throwable cause) { 
    }

    // The second of the three Interface MqttCallback's methods that must be included
    // Use for when a message arrives via the broker from the publisher of 
    // the topic we subscribed to  - room1/sensehat/temp. 
    // We override the method with what we would like to do with the value of the 
    // temp received 
    // For now we get the payload (the temp) and parse it from String to double  
    

    public void messageArrived(String topic, MqttMessage message) throws Exception {
        System.out.println("-------------------------------------------------");
    	// convert the received temp from type String to type double
        	double value = Double.parseDouble(new String(message.getPayload()));
        	
        	// Print  the topic, the String message and the double value

            System.out.println("-------------------------------------------------");
            System.out.println("| Topic:" + topic);
            System.out.println("| Message: " + new String(message.getPayload()));
            System.out.println("-------------------------"+value);
            
            // Create a Room object with the temp value
            //which has a getter and setter for the Temperature value and Id for the reading
            
            Rooms r1=	new Rooms(value);
            
         // Get the temp value and the Id for the 
         //which has a getter and setter for the Temperature value
            
            System.out.println("The temperature for reading number "+r1.getId()+ " is "+r1.getTemp());       

        }
    
    // The third of the three Interface MqttCallback's methods that must be included
    // Called when an outgoing publish is complete
    // As this client is only subscribing, this method is not used but
    // it must be included as it is one of the interface MqttCallBack Methods
   
     public void deliveryComplete(IMqttDeliveryToken token) {
     }
}
