package com.example.logreg;

import java.io.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Register {

    @FXML
    public TextField username;
    @FXML
    public PasswordField password;
    @FXML
    public Label RegLabel;

    private Parent root;
    private Scene scene;
    private Stage stage;

    @FXML
    public void onRegistrationClick(ActionEvent event) throws Exception {
        String userName = username.getText();
        String Password = password.getText();

        // Check if the username and password are empty
        if (userName.isEmpty() || Password.isEmpty()) {
            RegLabel.setText("Please enter username and password");
            return;
        }

        // Check if the user information file exists and is not empty
        File file = new File("C:\\Users\\pream\\Desktop\\userInfo.txt");
        if (file.exists()) {
            try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr)) {
                if (br.readLine() != null) {
                    RegLabel.setText("User information file already exists. Please delete the file or create a new account.");
                    return;
                }
            } catch (IOException e) {
                System.out.println("Error reading user information file: " + e.getMessage());
                return;
            }
        }

        // Create a new file to store the user information
        try (FileWriter fw = new FileWriter(file); BufferedWriter bw = new BufferedWriter(fw)) {
            // Write the user information to the file
            bw.write(userName + "&" + Password);

            // Close the BufferedWriter and FileWriter
            bw.close();
            fw.close();

            // Show a success message
            RegLabel.setText("Registration successful");

            // Switch to the login screen
            switchToLog(event);
        } catch (IOException e) {
            System.out.println("Error writing user information to file: " + e.getMessage());
            RegLabel.setText("Error registering user. Please try again.");
        }
    }

    @FXML
    public void switchToLog(ActionEvent e) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}



