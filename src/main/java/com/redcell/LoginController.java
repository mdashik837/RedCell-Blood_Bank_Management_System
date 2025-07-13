package com.redcell;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.IOException;

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
        // Add listeners to clear error message when user starts typing
        username.textProperty().addListener((observable, oldValue, newValue) -> hideErrorMessage());
        password.textProperty().addListener((observable, oldValue, newValue) -> hideErrorMessage());
    }
    
    @FXML
    private void handleLogin() {
        String user = username.getText().trim();
        String pass = password.getText().trim();
        
        // Validate input fields
        if (user.isEmpty() || pass.isEmpty()) {
            showErrorMessage("Please fill in all fields");
            return;
        }
        
        // TODO: Implement actual authentication logic
        // Assuming login is successful for now

        // Show success pop-up
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Login Successful");
        alert.setHeaderText(null);
        alert.setContentText("You have successfully logged in!");

        // Apply custom style to the alert
        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());
        dialogPane.getStyleClass().add("custom-alert");

        alert.showAndWait();

    }
    
    private void showErrorMessage(String message) {
        errorMessage.setText(message);
        errorMessage.setVisible(true);
        errorMessage.setManaged(true);
    }
    
    private void hideErrorMessage() {
        errorMessage.setVisible(false);
        errorMessage.setManaged(false);
    }
} 