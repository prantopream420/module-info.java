package com.example.logreg;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        // Check if the user has an account
        File file = new File("C:\\Users\\pream\\Desktop\\userInfo.txt");
        if (!file.exists()) {
            // Display a message asking the user to create an account
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Create an account");
            alert.setHeaderText("You need to create an account before you can log in.");
            alert.setContentText("Please click the OK button to create an account.");
            alert.showAndWait();

            // Load the registration FXML
            Parent root = FXMLLoader.load(getClass().getResource("Register.fxml"));

            // Create a scene and set it to the stage
            Scene scene = new Scene(root);
            stage.setScene(scene);

            // Show the stage
            stage.show();

            return;
        }

        // Load the login screen
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));

        // Create a scene and set it to the stage
        Scene scene = new Scene(root);
        stage.setScene(scene);

        // Show the stage
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}


