package gov.iti.jets.carspathtransition;

import javafx.animation.AnimationTimer;
import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;


/**
 * JavaFX App
 */
public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) {
        Path track = new Path();
        track.getElements().add(new MoveTo(450, 300));
        track.getElements().add(new CubicCurveTo(550 * 1.5, 0, 550 * 1.5, 400 * 1.5, 300 * 1.5, 200 * 1.5));
        track.getElements().add(new CubicCurveTo(50 * 1.5, 0, 50* 1.5, 400 * 1.5, 300 * 1.5, 200 * 1.5));

        track.setStroke(Color.BLUEVIOLET);
        track.setStrokeWidth(60);
        track.setFill(null);


        Path line = new Path();
        line.getElements().add(new MoveTo(450, 300));
        line.getElements().add(new CubicCurveTo(550 * 1.5, 0, 550 * 1.5, 400 * 1.5, 300 * 1.5, 200 * 1.5));
        line.getElements().add(new CubicCurveTo(50 * 1.5, 0, 50* 1.5, 400 * 1.5, 300 * 1.5, 200 * 1.5));
        line.setStroke(Color.WHITE);
        line.getStrokeDashArray().add(10.0);
        line.setFill(null);

        ImageView car1 = new ImageView(new Image(getClass().getResourceAsStream("car.png")));
        car1.setFitWidth(40);
        car1.setFitHeight(40);

        ImageView car2 = new ImageView(new Image(getClass().getResourceAsStream("car.png")));
        car2.setFitWidth(40);
        car2.setFitHeight(40);

        PathTransition car1Transition = new PathTransition(Duration.seconds(15), line, car1);
        car1Transition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        car1Transition.setCycleCount(PathTransition.INDEFINITE);

        PathTransition car2Transition = new PathTransition(Duration.seconds(15), line, car2);
        car2Transition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        car2Transition.setCycleCount(PathTransition.INDEFINITE);
        car2Transition.jumpTo(Duration.seconds(5));

        car1.setOnMouseClicked(e -> {
            car1Transition.setRate(car1Transition.getRate() * -1);
            car1.setScaleX(car1.getScaleX() * -1);

        });
        car2.setOnMouseClicked(e -> {
            car2Transition.setRate(car2Transition.getRate() * -1);
            car2.setScaleX(car2.getScaleX() * -1);

        });

        car1Transition.play();
        car2Transition.play();

        AnimationTimer collisionChecker = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (car1.getBoundsInParent().intersects(car2.getBoundsInParent())) {
                    car1Transition.setRate(car1Transition.getRate() * -1);
                    car2Transition.setRate(car2Transition.getRate() * -1);
                    car1.setScaleX(car1.getScaleX() * -1);
                    car2.setScaleX(car2.getScaleX() * -1);

                }
            }
        };
        collisionChecker.start();

        Pane root = new Pane(track,line,car1,car2);
        stage.setScene(new Scene(root, 800, 500));
        stage.show();
    }

}