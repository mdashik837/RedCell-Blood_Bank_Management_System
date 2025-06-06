package com.redcell;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class TrackRequestController {
    @FXML
    private TextField requestId;
    
    @FXML
    private Button trackButton;
    
    @FXML
    private VBox requestDetails;
    
    @FXML
    private Text status;
    
    @FXML
    private Text bloodType;
    
    @FXML
    private Text units;
    
    @FXML
    private Text hospital;
    
    @FXML
    private Text requiredDate;
    
    @FXML
    private Text errorMessage;
    
    @FXML
    public void initialize() {
        trackButton.setOnAction(e -> handleTrack());
        errorMessage.setVisible(false);
        requestDetails.setVisible(false);
    }
    
    private void handleTrack() {
        String id = requestId.getText();
        
        if (id.isEmpty()) {
            showError("Please enter a request ID");
            requestDetails.setVisible(false);
            return;
        }
        
        // TODO: Implement actual tracking logic
        // For now, just show dummy data
        showError("");
        displayRequestDetails(
            "Pending",
            "A+",
            "2",
            "City Hospital",
            "2024-03-20"
        );
    }
    
    private void displayRequestDetails(String statusText, String bloodTypeText,
                                     String unitsText, String hospitalText,
                                     String dateText) {
        status.setText(statusText);
        bloodType.setText(bloodTypeText);
        units.setText(unitsText);
        hospital.setText(hospitalText);
        requiredDate.setText(dateText);
        requestDetails.setVisible(true);
    }
    
    private void showError(String message) {
        errorMessage.setText(message);
        errorMessage.setVisible(!message.isEmpty());
    }
} 