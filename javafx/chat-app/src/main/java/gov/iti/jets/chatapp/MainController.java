package gov.iti.jets.chatapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class MainController {

    @FXML
    private TextField messageField;

    @FXML
    private VBox messageVBox;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private Button sendButton;

    @FXML
    private ImageView userPicture;

    @FXML
    private Label usernameLabel;

    public void setUserData(String username, Image image) {
        usernameLabel.setText(username);
        userPicture.setImage(image);
    }

    @FXML
    void onSendPressed(ActionEvent event) {
        String text = messageField.getText();

        if (text == null || text.trim().isEmpty()) {
            return;
        }

        Label nameLabel = new Label(usernameLabel.getText());
        nameLabel.setStyle("-fx-font-size: 10px;");

        ImageView imgView = new ImageView(userPicture.getImage());
        imgView.setFitWidth(20);
        imgView.setFitHeight(20);
        imgView.setPreserveRatio(true);

        VBox rightSide = new VBox(nameLabel, imgView);
        rightSide.setSpacing(3);


        Label msgLabel = new Label(text);
        msgLabel.setWrapText(true);
        msgLabel.setStyle("-fx-background-color: #e0f7fa; -fx-padding: 8; -fx-background-radius: 10;");

        HBox msgBox = new HBox(msgLabel,rightSide);
        msgBox.setSpacing(10);
        msgBox.setStyle("-fx-alignment: CENTER_RIGHT;");

        messageVBox.getChildren().add(msgBox);

        scrollPane.setVvalue(1.0);

        messageField.clear();
    }

}
