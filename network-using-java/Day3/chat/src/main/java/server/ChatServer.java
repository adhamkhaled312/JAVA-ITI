package server;

import interfaces.ChatClientInt;
import interfaces.ChatServerInt;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;


public class ChatServer extends UnicastRemoteObject implements ChatServerInt {

    private Vector v = new Vector ();

    public ChatServer() throws RemoteException {
    }

    public boolean login(ChatClientInt a) throws RemoteException {
        System.out.println (a.getName () + "  got connected....");
        a.tell ("You have Connected successfully.");
        publish (a.getName () + " has just connected.");
        v.add (a);
        return true;
    }

    public void publish(String s) throws RemoteException {
        System.out.println (s);
        for (int i = 0; i < v.size (); i++) {
            try {
                ChatClientInt tmp = (ChatClientInt) v.get (i);
                tmp.tell (s);
            } catch (Exception e) {
                //problem with the client not connected.
                //Better to remove it
            }
        }
    }

    public Vector getConnected() throws RemoteException {
        return v;
    }

	@Override
	public void logout(ChatClientInt a) throws RemoteException {
		System.out.println (a.getName () + "  got Disconnected....");
		a.tell ("You have Disconnected.");
		publish (a.getName () + " has just Disconnected");
		v.remove (a);
	}
}
