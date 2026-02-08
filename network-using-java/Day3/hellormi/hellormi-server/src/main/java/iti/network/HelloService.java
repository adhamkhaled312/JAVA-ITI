package iti.network;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface HelloService extends Remote {
    String sendMessage(String clientMessage) throws RemoteException;
    String sayBye() throws RemoteException;
}
