package iti.network;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class HelloServiceClient {
    public static void main(String[] args){
        try {
            Registry registry = LocateRegistry.getRegistry ("127.0.0.1",1099);
            try {
                HelloService stub = (HelloService) registry.lookup ("Hello");
                System.out.println(stub.sendMessage ("RMI IS Easy"));

                String[] services = registry.list();
                System.out.println("\nAvailable Services:");
                for(String service : services){
                    System.out.println(service);

                }
            } catch (NotBoundException e) {
                e.printStackTrace ();
            }
        } catch (RemoteException e) {
            e.printStackTrace ();
        }
    }
}
