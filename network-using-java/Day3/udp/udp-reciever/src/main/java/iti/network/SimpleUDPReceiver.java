package iti.network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Arrays;

public class SimpleUDPReceiver {
    public static void main(String[] args) {
        try (DatagramSocket dgSocket = new DatagramSocket(5000)){
            byte[] byteBuffer = new byte[1000];
            while (true) {
                Arrays.fill(byteBuffer, (byte) 0);   
                DatagramPacket dgRequest = new DatagramPacket(byteBuffer, byteBuffer.length);
                dgSocket.receive(dgRequest);
                System.out.println(new String(dgRequest.getData()).trim());
            }
        } catch (SocketException e) {
            System.out.println("Socket Exception : " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO Exception : " + e.getMessage());
        }
    }
}
