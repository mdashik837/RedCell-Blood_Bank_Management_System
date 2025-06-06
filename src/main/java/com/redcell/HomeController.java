package com.redcell;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.text.TextAlignment;
import javafx.geometry.Pos;
import javafx.geometry.Insets;

public class HomeController {
    
    @FXML
    private Text mostRequestedType;
    
    @FXML
    private Text pendingRequests;
    
    @FXML
    private Text livesSaved;

    @FXML
    public void initialize() {
        // Initialize statistics
        mostRequestedType.setText("O+");
        pendingRequests.setText("12");
        livesSaved.setText("1,234");
    }

    @FXML
    private void showNewsDetails1() {
        showNewsPopup("World Blood Donor Day Campaign",
                "Join us for World Blood Donor Day on June 14th!\n\n" +
                "We're organizing a massive blood donation drive across multiple locations. " +
                "Your single donation can save up to 3 lives!\n\n" +
                "• Free health checkup for donors\n" +
                "• Refreshments provided\n" +
                "• Special recognition for regular donors\n\n" +
                "Location: Multiple centers citywide\n" +
                "Time: 8 AM - 6 PM\n" +
                "Date: June 14th, 2024");
    }

    @FXML
    private void showNewsDetails2() {
        showNewsPopup("Emergency Blood Drive Alert",
                "Critical Blood Shortage - Immediate Action Required!\n\n" +
                "We are experiencing a severe shortage of B- and O- blood types. " +
                "If you are eligible to donate, please visit your nearest donation center.\n\n" +
                "Current Critical Needs:\n" +
                "• B-negative: Less than 2 days supply\n" +
                "• O-negative: Less than 3 days supply\n\n" +
                "Extended Hours:\n" +
                "We've extended our center hours to 7 AM - 9 PM all week.\n" +
                "Walk-ins welcome!");
    }

    private void showNewsPopup(String title, String content) {
        Stage popupStage = new Stage(StageStyle.DECORATED);
        popupStage.initModality(Modality.APPLICATION_MODAL);
        popupStage.setTitle(title);

        Label contentLabel = new Label(content);
        contentLabel.setWrapText(true);
        contentLabel.setTextAlignment(TextAlignment.LEFT);
        contentLabel.setStyle("-fx-font-size: 14px; -fx-font-family: 'Segoe UI';");

        VBox popupContent = new VBox(contentLabel);
        popupContent.setAlignment(Pos.CENTER);
        popupContent.setPadding(new Insets(20));
        popupContent.setStyle("-fx-background-color: white;");
        popupContent.setSpacing(10);

        Scene scene = new Scene(popupContent, 400, 300);
        popupStage.setScene(scene);
        popupStage.show();
    }
} 