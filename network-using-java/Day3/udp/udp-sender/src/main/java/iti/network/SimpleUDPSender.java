package iti.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class SimpleUDPSender {
    public static void main(String args[]) {
        
        try (InputStream is = SimpleUDPSender.class.getClassLoader().getResourceAsStream("test.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            DatagramSocket dgSocket = new DatagramSocket() ){

            String line;
            
            while((line = reader.readLine()) != null){
                byte[] data = line.getBytes();
                DatagramPacket packet = new DatagramPacket(data, data.length, InetAddress.getLocalHost(), 5000);
                dgSocket.send(packet);
                Thread.sleep(200);
            }
        } catch (SocketException e) {
            System.out.println("Socket Exception: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO Exception : " + e.getMessage());
        } 
        catch(Exception e){
            e.printStackTrace();
        }  
    }
}
