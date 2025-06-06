package com.redcell;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class RequestBloodController {
    @FXML
    private ComboBox<String> bloodType;
    
    @FXML
    private TextField units;
    
    @FXML
    private TextField hospital;
    
    @FXML
    private TextArea reason;
    
    @FXML
    private DatePicker requiredDate;
    
    @FXML
    private Button submitButton;
    
    @FXML
    private Text errorMessage;
    
    @FXML
    public void initialize() {
        submitButton.setOnAction(e -> handleSubmit());
        errorMessage.setVisible(false);
    }
    
    private void handleSubmit() {
        // Validate all fields
        if (bloodType.getValue() == null || units.getText().isEmpty() ||
            hospital.getText().isEmpty() || reason.getText().isEmpty() ||
            requiredDate.getValue() == null) {
            showError("Please fill in all fields");
            return;
        }
        
        try {
            int unitCount = Integer.parseInt(units.getText());
            if (unitCount <= 0) {
                showError("Please enter a valid number of units");
                return;
            }
        } catch (NumberFormatException e) {
            showError("Please enter a valid number of units");
            return;
        }
        
        // TODO: Implement actual request submission logic
        // For now, just show success
        showError("");
    }
    
    private void showError(String message) {
        errorMessage.setText(message);
        errorMessage.setVisible(!message.isEmpty());
    }
} 