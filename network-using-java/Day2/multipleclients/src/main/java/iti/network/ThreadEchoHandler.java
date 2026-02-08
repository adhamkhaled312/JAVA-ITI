package iti.network;

import java.net.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

class ThreadedEchoHandler implements Runnable
{
    private final Socket incoming;

    public ThreadedEchoHandler(Socket incomingSocket) {
        incoming = incomingSocket;
    }

    public void run()
    {
        PrintWriter out = null; 

        try (InputStream inStream = incoming.getInputStream();
             OutputStream outStream = incoming.getOutputStream())
        {
            Scanner in = new Scanner(inStream, StandardCharsets.UTF_8);
            out = new PrintWriter(outStream, true);
            ThreadedEchoServer.writers.add(out);

            out.println("Welcome to the chat! Type BYE to exit.");

            boolean done = false;
            while (!done && in.hasNextLine()) {
                
                String line = in.nextLine();
                for (PrintWriter writer : ThreadedEchoServer.writers) {
                        writer.println("Client says: " + line);
                    }

                if (line.trim().equalsIgnoreCase("BYE"))
                    done = true;
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally
        {
            if (out != null) {
                ThreadedEchoServer.writers.remove(out);
            }
            try {
                incoming.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
