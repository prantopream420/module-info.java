package com.example.logreg;

import java.util.Arrays;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class TrainTicketingController {

    @FXML
    private ComboBox<String> destinationComboBox;
    @FXML
    private ComboBox<String> timeComboBox;
    @FXML
    private ComboBox<String> trainComboBox;
    @FXML
    private Button bookTicketButton;

    private Parent root;
    private Scene scene;
    private Stage stage;

    @FXML
    public void initialize(ActionEvent e) {
        // Populate the destination comboBox
        destinationComboBox.getItems().addAll(Arrays.asList("Dhaka", "Chittagong", "Sylhet", "Rajshahi"));

        // Update the time comboBox based on the selected destination
        destinationComboBox.setOnAction(event -> {
            String selectedDestination = destinationComboBox.getSelectionModel().getSelectedItem();
            timeComboBox.getItems().clear();
            timeComboBox.getItems().addAll(getTimesForDestination(selectedDestination));

            // Update the train comboBox based on the selected destination and time
            trainComboBox.getItems().clear();
            trainComboBox.getItems().addAll(getTrainsForDestination(selectedDestination, timeComboBox.getSelectionModel().getSelectedItem()));

            // Enable the book ticket button only if all fields are selected
            bookTicketButton.setDisable(destinationComboBox.getSelectionModel().getSelectedItem() == null || timeComboBox.getSelectionModel().getSelectedItem() == null || trainComboBox.getSelectionModel().getSelectedItem() == null);
        });

        // Update the train comboBox based on the selected time
        timeComboBox.setOnAction(event -> {
            String selectedDestination = destinationComboBox.getSelectionModel().getSelectedItem();
            String selectedTime = timeComboBox.getSelectionModel().getSelectedItem();
            trainComboBox.getItems().clear();
            trainComboBox.getItems().addAll(getTrainsForDestination(selectedDestination, selectedTime));

            // Enable the book ticket button only if all fields are selected
            bookTicketButton.setDisable(destinationComboBox.getSelectionModel().getSelectedItem() == null || timeComboBox.getSelectionModel().getSelectedItem() == null || trainComboBox.getSelectionModel().getSelectedItem() == null);
        });

        // Disable the book ticket button until all fields are selected
        bookTicketButton.setDisable(true);

        // Add an action listener to the book ticket button to book the ticket
        bookTicketButton.setOnAction(event -> {
            // Get the selected destination, time, and train
            String selectedDestination = destinationComboBox.getSelectionModel().getSelectedItem();
            String selectedTime = timeComboBox.getSelectionModel().getSelectedItem();
            String selectedTrain = trainComboBox.getSelectionModel().getSelectedItem();

            // Book the ticket
            // TODO: Implement the bookTicket() method to book the ticket

            // Show a success message
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success!");
            alert.setHeaderText("Your ticket has been booked successfully!");
            alert.setContentText("Your ticket details are as follows:\n\n" +
                    "Destination: " + selectedDestination + "\n" +
                    "Time: " + selectedTime + "\n" +
                    "Train: " + selectedTrain);
            alert.showAndWait();

            // Close the train ticketing screen
            stage.close();
        });
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    private String[] getTimesForDestination(String destination) {
        // TODO: Implement the getTimesForDestination() method to return the possible times for the selected destination
        return new String[]{};
    }

    private String[] getTrainsForDestination(String destination, String time) {
        // TODO: Implement the getTrainsForDestination() method to return the possible trains for the selected destination and time
        return new String[]{};
    }
}


