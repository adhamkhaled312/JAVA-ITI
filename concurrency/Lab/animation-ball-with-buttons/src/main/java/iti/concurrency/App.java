package iti.concurrency;

import javax.swing.JFrame;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class App extends Application implements Runnable {


    private ImageView ball;
    private double dx=4, dy=4;
    private Thread thread;
    Scene scene;
    private volatile boolean paused = false;
    @Override
    public void start(Stage stage) {
        Pane root = new Pane();
        scene = new Scene(root, 600, 400);

        Image ballImage = new Image("ball.jpeg");
        ball = new ImageView(ballImage);
        ball.setFitWidth(40);
        ball.setFitHeight(40);

        ball.setX(200);
        ball.setY(300);

        Button resumeButton = new Button("Resume");
        Button pauseButton = new Button("Pause");

        resumeButton.setLayoutX(260);
        resumeButton.setLayoutY(20);

        pauseButton.setLayoutX(340);
        pauseButton.setLayoutY(20);

        resumeButton.setOnAction(e-> paused = false);
        pauseButton.setOnAction(e-> paused = true);

        root.getChildren().addAll(ball,resumeButton,pauseButton);

        stage.setTitle("Bouncing Ball");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        

        
        thread = new Thread(this);
        thread.start();
        
    }

    @Override
    public void run() {
        while (true) {
            if(!paused){
                ball.setX(ball.getX() + dx);
                ball.setY(ball.getY() + dy);
                
                if (ball.getX() < 0 || ball.getX() > scene.getWidth() - ball.getFitWidth()) {
                    dx = -dx; 
                }
                if (ball.getY() < 0 || ball.getY() > scene.getHeight() - ball.getFitHeight()) {
                    dy = -dy; 
                }
                try {
                    Thread.sleep(20); 
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }


        }
    }

    public static void main(String[] args) {
        launch();
    }
}
