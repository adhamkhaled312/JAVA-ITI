package iti.concurrency;

import java.util.concurrent.RunnableScheduledFuture;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.application.Platform;

/**
 * JavaFX App
 */
public class App extends Application implements Runnable {
    Label label;
    Scene scene;

    @Override
    public void start(Stage stage) {
        label = new Label("Adham Khaled");
        
        Pane root = new Pane(label);
        scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.setTitle("Marquee String Application");
        stage.setResizable(false);

        label.setLayoutX((scene.getWidth() - label.getWidth()) / 2);
        label.setLayoutY((scene.getHeight() - label.getHeight()) / 2);
        stage.show();

        Thread th = new Thread(this);
        th.setDaemon(true);
        th.start();
    }
    
    @Override
    public void run(){
        while(true){
            double x = label.getLayoutX()+2;
            label.setLayoutX(x);

            if(x > scene.getWidth()){
                label.setLayoutX(-label.getWidth());
            }
            try{
                Thread.sleep(15);
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
        }
    public static void main(String[] args) {
        launch();
    }

}