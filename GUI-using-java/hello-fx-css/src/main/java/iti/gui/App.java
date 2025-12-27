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

    @Override
    public void start(Stage stage) {

        Label label = new Label("Hello World");
        label.setId("hello-label");

        StackPane root = new StackPane(label);
        root.getStyleClass().add("root-pane");

        Scene scene = new Scene(root, 600, 500);
        scene.getStylesheets().add(getClass().getResource("/style.css").toString());

        stage.setTitle("JavaFX CSS LinearGradient");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}