package iti.concurrency;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ){
        List<Integer> list = new ArrayList<>();

        List<Integer> firstList  = new ArrayList<>();
        List<Integer> secondList = new ArrayList<>();
        List<Integer> thirdList  = new ArrayList<>();

        for (int i = 1; i <= 10000; i++) {
            firstList.add(i);
        }

        for (int i = 10001; i <= 20000; i++) {
            secondList.add(i);
        }

        for (int i = 20001; i <= 30000; i++) {
            thirdList.add(i);
        }
        Thread th1 = new Thread(() -> appendArray(list, firstList));
        Thread th2 = new Thread(() -> appendArray(list, secondList));
        Thread th3 = new Thread(() -> appendArray(list, thirdList));

        th1.start();
        th2.start();
        th3.start();


        try{
        th1.join();
        th2.join();
        th3.join();
        }
        catch(Exception e){
            e.printStackTrace();
        }

        System.out.println(list.size());
    }


    public static synchronized void appendArray(List<Integer> list, List<Integer> elements){
        for(Integer i : elements ){
            list.add(i);    
        }   
    }
}
