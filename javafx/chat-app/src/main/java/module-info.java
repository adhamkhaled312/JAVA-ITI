module gov.iti.jets.chatapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens gov.iti.jets.chatapp to javafx.fxml;
    exports gov.iti.jets.chatapp;
}