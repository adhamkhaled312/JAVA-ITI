package iti.network;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CalculatorClient {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Example: java CalculatorClient 30 + 40");
            return;
        }

        try {
            double a = Double.parseDouble(args[0]);
            String op = args[1];
            double b = Double.parseDouble(args[2]);

            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 1099);
            CalculatorService calc = (CalculatorService) registry.lookup("Calculator");

            double result = 0.0;

            switch (op) {
                case "+":
                    result = calc.add(a, b);
                    break;
                case "-":
                    result = calc.subtract(a, b);
                    break;
                case "*":
                    result = calc.multiply(a, b);
                    break;
                case "/":
                    result = calc.divide(a, b);
                    break;
                default:
                    System.out.println("Unknown Operation");
            }   

            System.out.println("Result: " + result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
