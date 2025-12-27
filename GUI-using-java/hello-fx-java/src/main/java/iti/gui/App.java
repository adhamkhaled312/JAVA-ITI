package iti.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import javafx.scene.paint.Color;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.Stop;

import javafx.scene.effect.Reflection;

import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {

        Label label = new Label("Hello World");
        label.setFont(Font.font("Arial", FontWeight.BOLD, 45));
        label.setTextFill(Color.RED);

        Reflection reflection = new Reflection();
        reflection.setFraction(1);
        reflection.setTopOpacity(0);
        reflection.setBottomOpacity(0.9);
        label.setEffect(reflection);

        LinearGradient gradient = new LinearGradient(
                0, 0, 1, 0, true,
                CycleMethod.NO_CYCLE,
                new Stop(0, Color.BLACK),
                new Stop(0.5, Color.LIGHTGRAY),
                new Stop(1, Color.BLACK)
        );

        StackPane root = new StackPane(label);
        root.setBackground(
                new Background(new BackgroundFill(gradient, null, null))
        );

        Scene scene = new Scene(root, 600, 500);

        stage.setTitle("JavaFX Reflection + Gradient");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}