package rmi_question_2;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class UserClient {

    public static void main(String[] args) {
        String url = "rmi:///";
        System.out.println("Client has started");
        String host = (args.length < 1) ? null : args[0];
        try {
            Registry registry = LocateRegistry.getRegistry("localhost",1098);
            UserInterface stub = (UserInterface) registry.lookup(url+"st");
            String response = stub.getAccessLevel();
            System.out.println("response: " + response);
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}