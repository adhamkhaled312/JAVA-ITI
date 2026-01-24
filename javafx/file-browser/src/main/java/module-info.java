module gov.iti.jets.filebrowser {
    requires javafx.controls;
    requires javafx.fxml;


    opens gov.iti.jets.filebrowser to javafx.fxml;
    exports gov.iti.jets.filebrowser;
}