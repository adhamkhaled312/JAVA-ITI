package iti.concurrency;

import java.util.concurrent.ScheduledExecutorService;

import java.util.concurrent.RunnableScheduledFuture;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.application.Platform;
import java.util.concurrent.*;

/**
 * JavaFX App
 */
public class App extends Application  {
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

        
        
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleAtFixedRate(()->{
            double x = label.getLayoutX()+2;
            label.setLayoutX(x);
            if(x > scene.getWidth()){
                label.setLayoutX(-label.getWidth());
            }
        },0,15,TimeUnit.MILLISECONDS);

        stage.setOnCloseRequest(e -> executorService.shutdownNow());
    }

    public static void main(String[] args) {
        launch();
    }

}