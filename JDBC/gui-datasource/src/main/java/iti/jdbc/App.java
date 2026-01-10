package iti.jdbc;


import javax.sql.*;
import java.sql.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.util.function.Predicate;

public class App extends Application {
    private TextField textId, textFirst, textMiddle, textLast, textEmail, textPhone;
    private Button buttonNew, buttonUpdate, buttonDelete, buttonFirst, buttonPrev, buttonNext, buttonLast;
    DataSource dataSource;
    Connection connection;
    Statement statement;
    ResultSet resultSet=null;
    boolean newPerson=true;

    @Override
    public void start(Stage stage) {
        // Text Fields
        textId = new TextField();
        textFirst = new TextField();;
        textMiddle = new TextField();
        textLast = new TextField();
        textEmail = new TextField();
        textPhone = new TextField();
        textId.setEditable(false);
        textId.setStyle("-fx-text-fill: grey;");


        GridPane grid = new GridPane();
        grid.setVgap(5);
        grid.setHgap(5);
        grid.setPadding(new Insets(10));

        grid.addRow(0, new Label("ID"), textId);
        grid.addRow(1, new Label("First Name"), textFirst);
        grid.addRow(2, new Label("Middle Name"), textMiddle);
        grid.addRow(3, new Label("Last Name"), textLast);
        grid.addRow(4, new Label("Email"), textEmail);
        grid.addRow(5, new Label("Phone"), textPhone);

        // Buttons
        buttonNew = new Button("New");
        buttonUpdate = new Button("Update");
        buttonDelete = new Button("Delete");
        buttonFirst = new Button("First");
        buttonPrev = new Button("Previous");
        buttonNext = new Button("Next");
        buttonLast = new Button("Last");

        HBox buttonBox = new HBox(5, buttonNew, buttonUpdate, buttonDelete, buttonFirst, buttonPrev, buttonNext, buttonLast);
        VBox root = new VBox(10, grid, buttonBox);
        root.setPadding(new Insets(10));

        Scene scene = new Scene(root, 400, 270);
        stage.setScene(scene);
        stage.setTitle("Person Details");
        stage.show();
        

        try{
            dataSource = MyDataSourceFactory.getMySqlDataSource();
            connection = dataSource.getConnection();
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            resultSet = statement.executeQuery("select id, firstname, middlename, lastname, email, phone from person");

            if (resultSet.next()) {
                resultSet.first();
                load();
                newPerson = true;
            } else {
                prepareForNewPerson();
            }

        }
        catch(Exception e){
            e.printStackTrace();
        }
        buttonFirst.setOnAction(e -> {
            try {
                if (resultSet.first()) { 
                    load();
                    newPerson=true;
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });

        buttonPrev.setOnAction(e -> {
            try {
                if (resultSet.previous()) { 
                    load();
                    newPerson=true;
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });

        buttonNext.setOnAction(e -> {
            try {
                if (resultSet.next()) { 
                    load();
                    newPerson=true;
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });

        buttonLast.setOnAction(e -> {
            try {
                if (resultSet.last()) { 
                    load();
                    newPerson=true;
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });

        buttonNew.setOnAction(e -> insertNew());
        buttonUpdate.setOnAction(e -> updateCurrent());
        buttonDelete.setOnAction(e->deleteCurrent());
    }
    public void load(){
        try{
            textId.setText(resultSet.getString("id"));
            textFirst.setText(resultSet.getString("firstname"));
            textMiddle.setText(resultSet.getString("middlename"));
            textLast.setText(resultSet.getString("lastname"));
            textEmail.setText(resultSet.getString("email"));
            textPhone.setText(resultSet.getString("phone"));
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }

private void insertNew() {
    try {
        if (!newPerson) {
            resultSet.moveToInsertRow();
            resultSet.updateInt("id", Integer.parseInt(textId.getText()));
            resultSet.updateString("firstname", textFirst.getText());
            resultSet.updateString("middlename", textMiddle.getText());
            resultSet.updateString("lastname", textLast.getText());
            resultSet.updateString("email", textEmail.getText());
            resultSet.updateString("phone", textPhone.getText());
            resultSet.insertRow();
            resultSet.moveToCurrentRow();
            resultSet.last();
            newPerson = true;

        }
        else{
            prepareForNewPerson();
        }
 

    } catch (SQLException e) {
        e.printStackTrace();
    }
}

    private void updateCurrent(){
        try {
            resultSet.updateString("firstname", textFirst.getText());
            resultSet.updateString("middlename", textMiddle.getText());
            resultSet.updateString("lastname", textLast.getText());
            resultSet.updateString("email", textEmail.getText());
            resultSet.updateString("phone", textPhone.getText());
            resultSet.updateRow();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

private void deleteCurrent() {
    try {
        if (resultSet.next() || resultSet.previous()) {
            resultSet.deleteRow();

            if (resultSet.next()) {
                load();
            } else if (resultSet.previous()) {
                load();
            } else {
                clearAllFields();
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}
 

    private void clearAllFields() {
        textId.clear();
        textFirst.clear();
        textMiddle.clear();
        textLast.clear();
        textEmail.clear();
        textPhone.clear();
    }
    private void prepareForNewPerson() {
        try {
            int nextId = 1;
            if (resultSet.last()) {
                nextId = resultSet.getInt("id") + 1;
            }
            clearAllFields();
            textId.setText(String.valueOf(nextId));
            textFirst.requestFocus();

            newPerson = false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
}
    @Override
    public void stop() {
        try{
            resultSet.close();
            statement.close();
            connection.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        launch();
    }
}
