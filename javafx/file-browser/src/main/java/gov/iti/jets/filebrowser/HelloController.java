package gov.iti.jets.filebrowser;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.DirectoryChooser;

import java.io.File;

public class HelloController {

    private Image folderIcon = new Image(getClass().getResourceAsStream("folder.png"));
    private Image fileIcon = new Image(getClass().getResourceAsStream("file.png"));

    @FXML
    private Button browseButton;

    @FXML
    private TreeView<File> directoryTree;

    @FXML
    private ListView<File> filesList;

    @FXML
    private TextField pathField;

    @FXML
    void initialize() {
        directoryTree.setCellFactory(tree -> new TreeCell<>() {
            @Override
            protected void updateItem(File item, boolean empty) {
                super.updateItem(item, empty);

                if (empty || item == null) {
                    setText(null);
                    setGraphic(null);
                } else {
                    setText(item.getName());
                    ImageView imageView = new ImageView(item.isDirectory() ? folderIcon : fileIcon);

                    imageView.setFitWidth(18);
                    imageView.setFitHeight(18);
                    setGraphic(imageView);
                }
            }
        });

        // Listen for selection changes
        directoryTree.getSelectionModel().selectedItemProperty().addListener((obs, oldSel, newSel) -> {
            if (newSel == null) return;

            File selectedFile = newSel.getValue();
            if (selectedFile.isDirectory()) {
                File[] files = selectedFile.listFiles();
                filesList.getItems().clear();
                if (files != null) {
                    for (File file : files) {
                        filesList.getItems().add(file);
                    }
                }
            } else {
                filesList.getItems().clear();
                filesList.getItems().add(selectedFile);
            }
        });

        filesList.setCellFactory(list -> new ListCell<>() {
            @Override
            protected void updateItem(File item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                    setGraphic(null);
                } else {
                    setText(item.getName());
                    ImageView imageView = new ImageView(item.isDirectory() ? folderIcon : fileIcon);
                    imageView.setFitWidth(18);
                    imageView.setFitHeight(18);
                    setGraphic(imageView);
                }
            }
        });
    }
    @FXML
    void onBrowseButtonPressed(ActionEvent event) {
        DirectoryChooser chooser = new DirectoryChooser();
        chooser.setTitle("Select a Folder");

        File selectedDir = chooser.showDialog(null);
        if (selectedDir != null) {
            pathField.setText(selectedDir.getAbsolutePath());
            TreeItem<File> rootItem = buildDirectoryTree(selectedDir);
            directoryTree.setRoot(rootItem);
            directoryTree.setShowRoot(true);
        }
    }

    private TreeItem<File> buildDirectoryTree(File dir) {
        TreeItem<File> root = new TreeItem<>(dir);

        File[] files = dir.listFiles();
        if (files == null) return root;

        for (File file : files) {

            if (file.isDirectory()) {
                TreeItem<File> childDir = buildDirectoryTree(file);
                root.getChildren().add(childDir);
            } else {
                TreeItem<File> fileItem = new TreeItem<>(file);
                root.getChildren().add(fileItem);
            }
        }
        return root;
    }

}
