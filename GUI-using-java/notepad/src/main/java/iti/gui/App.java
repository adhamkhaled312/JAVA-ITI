package iti.gui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {
    TextArea area;
    File currentFile;

    @Override
    public void start(Stage stage) {
        area = new TextArea();
        MenuBar bar = new MenuBar();

        /* File menu UI */
        Menu file = new Menu("File");
        MenuItem newItem = new MenuItem("New");
        MenuItem openItem = new MenuItem("Open");
        MenuItem saveItem = new MenuItem("Save");
        MenuItem exitItem = new MenuItem("Exit");
        file.getItems().addAll(newItem,openItem,saveItem,new SeparatorMenuItem(),exitItem);
        
        /* Edit menu UI */
        Menu edit = new Menu("Edit");
        MenuItem cutItem = new MenuItem("Cut");
        MenuItem copyItem = new MenuItem("Copy");
        MenuItem pasteItem = new MenuItem("Paste");
        MenuItem deleteItem = new MenuItem("Delete");
        MenuItem selectAllItem = new MenuItem("Select All");
        edit.getItems().addAll(cutItem,copyItem,pasteItem,deleteItem,new SeparatorMenuItem(),selectAllItem);

        /* Help menu UI */
        Menu help = new Menu("Help");
        MenuItem aboutItem = new MenuItem("About Notepad");
        help.getItems().add(aboutItem);

        /* Main UI */
        bar.getMenus().addAll(file,edit,help);
        BorderPane root = new BorderPane();
        root.setTop(bar);
        root.setCenter(area);
        Scene scene = new Scene(root, 500, 500);

        /* File menu actions */
        newItem.setOnAction(e->{
            area.clear();
            currentFile=null;
        });
        openItem.setOnAction(e->openFile(stage));
        saveItem.setOnAction(e->saveFile(stage));
        exitItem.setOnAction(e->stage.close());

        /* Edit menu actions */
        cutItem.setOnAction(e->area.cut());
        copyItem.setOnAction(e->area.copy());
        pasteItem.setOnAction(e->area.paste());
        deleteItem.setOnAction(e->area.replaceSelection(""));
        selectAllItem.setOnAction(e->area.selectAll());
        
        /* Help menu UI */
        aboutItem.setOnAction(e -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("About");
            alert.setHeaderText("My Notebad");
            alert.setContentText("Simple JavaFX Notepad Application\nITI Intake 46 - JavaFX");
            alert.showAndWait();
        });

        stage.setScene(scene);
        stage.setTitle("My Notepad");
        stage.show();
    }

    private void openFile(Stage stage) {
        FileChooser chooser = new FileChooser();
        chooser.getExtensionFilters().add( new FileChooser.ExtensionFilter("Text Files (*.txt)", "*.txt"));
        File file = chooser.showOpenDialog(stage);

        if (file != null) {
            currentFile = file;
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                area.clear();
                String line;
                while ((line = br.readLine()) != null) {
                    area.appendText(line + "\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void saveFile(Stage stage) {
        if (currentFile == null) {
            FileChooser chooser = new FileChooser();
            chooser.getExtensionFilters().add( new FileChooser.ExtensionFilter("Text Files (*.txt)", "*.txt"));
            currentFile = chooser.showSaveDialog(stage);
        }

        if (currentFile != null) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(currentFile))) {
                bw.write(area.getText());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        launch();
    }

}
