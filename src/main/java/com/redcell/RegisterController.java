package com.redcell;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class RegisterController {
    @FXML
    private TextField fullName;
    
    @FXML
    private TextField username;
    
    @FXML
    private PasswordField password;
    
    @FXML
    private PasswordField confirmPassword;
    
    @FXML
    private TextField email;
    
    @FXML
    private TextField phone;
    
    @FXML
    private Button registerButton;
    
    @FXML
    private Text errorMessage;
    
    @FXML
    public void initialize() {
        registerButton.setOnAction(e -> handleRegister());
        errorMessage.setVisible(false);
    }
    
    private void handleRegister() {
        // Validate all fields
        if (fullName.getText().isEmpty() || username.getText().isEmpty() ||
            password.getText().isEmpty() || confirmPassword.getText().isEmpty() ||
            email.getText().isEmpty() || phone.getText().isEmpty()) {
            showError("Please fill in all fields");
            return;
        }
        
        // Validate password match
        if (!password.getText().equals(confirmPassword.getText())) {
            showError("Passwords do not match");
            return;
        }
        
        // TODO: Implement actual registration logic
        // For now, just show success
        showError("");
    }
    
    private void showError(String message) {
        errorMessage.setText(message);
        errorMessage.setVisible(!message.isEmpty());
    }
} 