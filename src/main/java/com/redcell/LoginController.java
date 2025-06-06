package com.redcell;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class LoginController {
    @FXML
    private TextField username;
    
    @FXML
    private PasswordField password;
    
    @FXML
    private Button loginButton;
    
    @FXML
    private Text errorMessage;
    
    @FXML
    public void initialize() {
        loginButton.setOnAction(e -> handleLogin());
        errorMessage.setVisible(false);
    }
    
    private void handleLogin() {
        String user = username.getText();
        String pass = password.getText();
        
        if (user.isEmpty() || pass.isEmpty()) {
            showError("Please fill in all fields");
            return;
        }
        
        // TODO: Implement actual login logic
        // For now, just show success
        showError("");
    }
    
    private void showError(String message) {
        errorMessage.setText(message);
        errorMessage.setVisible(!message.isEmpty());
    }
} 