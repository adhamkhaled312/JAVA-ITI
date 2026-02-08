package iti.network;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class CalculatorServiceImpl extends UnicastRemoteObject implements CalculatorService {

    protected CalculatorServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public double add(double a, double b) {
        return a + b;
    }

    @Override
    public double subtract(double a, double b) {
        return a - b;
    }

    @Override
    public double multiply(double a, double b) {
        return a * b;
    }

    @Override
    public double divide(double a, double b) {
        return a / b;
    }

    public static void main(String[] args) {
        try {

            CalculatorService stub = new CalculatorServiceImpl();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("Calculator", stub);
            while (true){}

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
