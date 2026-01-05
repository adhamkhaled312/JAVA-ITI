package iti.concurrency;

import java.awt.BorderLayout;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class App extends JFrame implements Runnable{
    Thread th;
    Date d=new Date();
    JLabel timeLabel = new JLabel();

    public static void main( String[] args ){
        App app = new App();
        app.setBounds(50,50,600,600);
        app.setVisible(true);
    }

    public App(){
        this.setTitle("Date & Time Application");
        timeLabel.setHorizontalAlignment(JLabel.CENTER);
        timeLabel.setText(d.toString());
        this.add(timeLabel,BorderLayout.CENTER);
        th = new Thread(this);
        th.start();
        // th.run();
    }
    public void run(){
       while(true){
            try{
                d = new Date();
                timeLabel.setText(d.toString());   
                Thread.sleep(1000);
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
       }
    }
}
