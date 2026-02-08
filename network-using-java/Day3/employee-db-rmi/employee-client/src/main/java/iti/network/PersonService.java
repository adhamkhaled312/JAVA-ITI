package iti.network;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface PersonService extends Remote {

    void addPerson(Person person) throws RemoteException;

    void updatePerson(Person person) throws RemoteException;

    void deletePerson(int id) throws RemoteException;

    Person getPerson(int id) throws RemoteException;

    List<Person> getAllPersons() throws RemoteException;
}
