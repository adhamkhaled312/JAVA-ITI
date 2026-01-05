package iti.concurrency;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class App extends Application implements Runnable {


    private ImageView ball;
    private double dx=4, dy=4;
    private Thread thread;
    Scene scene;

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


        root.getChildren().add(ball);

        stage.setTitle("Bouncing Ball");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        

        
        thread = new Thread(this);
        thread.setDaemon(true); 
        thread.start();
    }

    @Override
    public void run() {
        while (true) {
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

    public static void main(String[] args) {
        launch();
    }
}
