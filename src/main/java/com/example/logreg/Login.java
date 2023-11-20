package com.example.logreg;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

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

public class Login {

    public TextField username;
    public PasswordField password;
    private Parent root;
    private Scene scene;
    private Stage stage;

    @FXML
    public void onLoginClick(ActionEvent e) throws Exception {
        String userName = username.getText();
        String Password = password.getText();
        File file = new File("C:\\Users\\pream\\Desktop\\userInfo.txt");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String data = br.readLine();
        String[] sdata = data.split("&");
        if (sdata[0].equals(userName) && sdata[1].equals(Password)) {
            System.out.println("Login Successful");

            // Load the ticketing FXML and switch to the ticketing scene
            Parent ticketingRoot = FXMLLoader.load(getClass().getResource("Ticketing.fxml"));
            Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            Scene ticketingScene = new Scene(ticketingRoot);
            stage.setScene(ticketingScene);
            stage.show();
        } else {
            Label loginLabel = (Label) scene.lookup("#loginLabel");
            loginLabel.setText("Invalid username or password");
        }
        br.close();
    }

    @FXML
    public void switchToReg(ActionEvent e) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Register.fxml"));
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}

