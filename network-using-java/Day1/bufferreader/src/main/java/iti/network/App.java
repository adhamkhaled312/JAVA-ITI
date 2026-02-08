package iti.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App 
{

    public static void main( String[] args ){
        try{
            String [] stringList = new String[100];
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            int i=0;
            System.out.println("Enter up to 100 line\nEnter \"stop\" to exit");
            while(i < 100){
                String line = bufferedReader.readLine();
                if(line == null || line.equals("stop")) break;

                stringList[i++] = line;
            }
            System.out.println();
            for(int j=0;j<i;j++) System.out.println(stringList[j]);

        } 
        catch(IOException e){
            e.printStackTrace();
        }


    }
}
