package iti.concurrency;

import java.util.concurrent.ExecutorService;

import java.awt.BorderLayout;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.util.concurrent.*;

public class App extends JFrame {
    static Date d=new Date();
    static JLabel timeLabel = new JLabel();

    public static void main( String[] args ){
        App app = new App();
        app.setBounds(50,50,600,600);
        app.setVisible(true);

        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

        executorService.scheduleAtFixedRate(()->{
                d = new Date();
                timeLabel.setText(d.toString());   
            }
        ,0,1,TimeUnit.SECONDS);
    }

    public App(){
        this.setTitle("Date & Time Application");
        timeLabel.setHorizontalAlignment(JLabel.CENTER);
        timeLabel.setText(d.toString());
        this.add(timeLabel,BorderLayout.CENTER);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
}
