module gov.iti.jets.carspathtransition {
    requires javafx.controls;
    requires javafx.fxml;


    opens gov.iti.jets.carspathtransition to javafx.fxml;
    exports gov.iti.jets.carspathtransition;
}