package com.redcell;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.StackPane;
import javafx.scene.Parent;
import java.io.IOException;

public class DashboardController {
    
    @FXML
    private StackPane contentArea;

    @FXML
    private void initialize() {
        // Load home view by default
        loadView("home");
    }

    @FXML
    private void handleHomeAction() {
        loadView("home");
    }

    @FXML
    private void handleLoginAction() {
        loadView("login");
    }

    @FXML
    private void handleRegisterAction() {
        loadView("register");
    }

    @FXML
    private void handleRequestBloodAction() {
        loadView("request-blood");
    }

    @FXML
    private void handleTrackRequestAction() {
        loadView("track-request");
    }

    private void loadView(String viewName) {
        try {
            Parent view = FXMLLoader.load(getClass().getResource("/views/" + viewName + ".fxml"));
            contentArea.getChildren().clear();
            contentArea.getChildren().add(view);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error loading " + viewName + " view: " + e.getMessage());
        }
    }
} 