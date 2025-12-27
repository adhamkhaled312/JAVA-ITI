package iti.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    public App(){
        String name = Thread.currentThread().getName();
        System.out.println("constructor(): current thread "+ name);
    }
    @Override
    public void start(Stage stage) {
        String name = Thread.currentThread().getName();
        System.out.println("start(): current thread "+ name);

        Label label = new Label("Life Cycle");
        Scene scene = new Scene(new StackPane(label), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void init() throws Exception{
        String name = Thread.currentThread().getName();
        System.out.println("init(): current thread "+ name);
        super.init(); 
    }

    @Override
    public void stop() throws Exception{
        String name = Thread.currentThread().getName();
        System.out.println("Stop(): current thread "+ name);
        super.stop();
    }

    public static void main(String[] args) {
        launch();
    }

}