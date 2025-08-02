package com.redcell;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LogoutController implements Initializable {

    @FXML
    private Button logoutButton;

    private DashboardController dashboardController;

    public void setDashboardController(DashboardController dashboardController) {
        this.dashboardController = dashboardController;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Initialization logic can go here
    }

    @FXML
    private void handleLogout() {
        // Load the login scene in the content area
        if (dashboardController != null) {
            dashboardController.loadView("login");
            // Optionally update login status in DashboardController
            dashboardController.setLoggedIn(false);
        } else {
            System.err.println("DashboardController not set on LogoutController.");
            // Fallback or error handling if dashboardController is null
        }
    }
}