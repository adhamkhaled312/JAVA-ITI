package iti.network;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class HelloServiceImpl extends UnicastRemoteObject implements HelloService{
    protected HelloServiceImpl() throws RemoteException {

    }
    @Override
    public String sendMessage(String clientMessage){
        return "Hello "+clientMessage;
    }
    @Override public String sayBye(){
        return "BYE";
    }
    
    public static void main(String[] args) throws RemoteException{
        HelloService stub=new HelloServiceImpl();
        Registry registry = LocateRegistry.createRegistry(1099);
        registry.rebind("Hello",stub);

        while(true){}
    }
}
