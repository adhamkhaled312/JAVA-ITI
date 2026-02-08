package iti.network;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Hello world!
 *
 */
public class App 
{
    public void serialize() {
        try (ObjectOutputStream objOStrm = new ObjectOutputStream(Files.newOutputStream(Paths.get("serial")))) {
            MyClass object1 = new MyClass("Hello", -7, 2.7e10);
            System.out.println("object1: " + object1);
            objOStrm.writeObject(object1);
        } catch (IOException e) {
            System.out.println("Exception during serialization: " + e);
        }
    }
    public void deserialize() {
        try (ObjectInputStream objIStrm = new ObjectInputStream(Files.newInputStream(Paths.get("serial")))) {
            MyClass object2 = (MyClass) objIStrm.readObject();
            System.out.println("object2: " + object2);
        } catch (Exception e) {
            System.out.println("Exception during deserialization: " + e);
        }
    }

    public static void main( String[] args )
    {
        App sd = new App();
        sd.serialize();
        sd.deserialize();
    }
}


class MyClass implements Serializable {
    String s;
    int i;
    double d;
     String demo="Transient Attribute";
    public MyClass(String s, int i, double d) {
        this.s = s;
        this.i = i;
        this.d = d;
    }
    public String toString() {
        return "s=" + s + "; i=" + i + "; d=" + d+"; demo = "+demo;
    }
}