package com.redcell;

import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableCell;
import javafx.scene.text.Text;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

public class DonorDashboardController {

    public static boolean isLoggedIn = false;

    @FXML
    private Text userNameText;
    
    @FXML
    private Text dateText;
    
    @FXML
    private Text bloodGroupText;
    
    @FXML
    private Text statusText;
    
    @FXML
    private Text locationText;
    
    @FXML
    private Text totalDonationCount;
    
    @FXML
    private Text lastDonationInfo;
    
    @FXML
    private ImageView badge1;
    
    @FXML
    private ImageView badge2;
    
    @FXML
    private TableView<Donation> bookDonationTable;
    
    @FXML
    private TableView<BloodAvailability> availableBloodTable;
    
    @FXML
    private ImageView adImageView;
    
    @FXML
    private VBox adSlideshow;
    
    private List<String> adImages = Arrays.asList(
        "/img/ad_01_emergency.png",
        "/img/ad_02_dangue.png",
        "/img/ad_03_FFP.png",
        "/img/ad_04_RCCorPRBC.png",
        "/img/ad_05_SDP.png",
        "/img/ad_06_Whole_blood.png",
        "/img/banner-ad-01.png",
        "/img/banner-ad-02.png"
    );
    
    private int currentAdIndex = 0;
    private Timeline slideShowTimeline;

    public static void setLoggedInState(boolean state) {
        isLoggedIn = state;
    }

    @FXML
    public void initialize() {
        // Initialize user information
        initializeUserInfo();
        
        // Initialize donation table
        initializeBookDonationTable();
        
        // Initialize available blood table
        initializeAvailableBloodTable();
        
        // Initialize donation statistics
        initializeDonationStats();
        
        // Initialize badges
        initializeBadges();
        
        // Initialize ad slideshow
        initializeAdSlideshow();
    }
    
    private void initializeUserInfo() {
        // Set current user information
        userNameText.setText("Hello " + "User");
        dateText.setText("Today is " + LocalDate.now().format(DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy")));
        bloodGroupText.setText("My Blood Group: " +"A(-ve)");
        statusText.setText("My Status: " + "ELIGIBLE");
        locationText.setText("Current Location: " + "Mirpur, Dhaka");
    }
    
    private void initializeBookDonationTable() {
        // Initialize table columns
        TableColumn<Donation, String> bloodTypeCol = new TableColumn<>("Blood Type");
        bloodTypeCol.setCellValueFactory(new PropertyValueFactory<>("bloodType"));

        TableColumn<Donation, Integer> unitsCol = new TableColumn<>("Units");
        unitsCol.setCellValueFactory(new PropertyValueFactory<>("units"));

        TableColumn<Donation, String> locationCol = new TableColumn<>("Location");
        locationCol.setCellValueFactory(new PropertyValueFactory<>("location"));

        TableColumn<Donation, LocalDate> dateCol = new TableColumn<>("Date");
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        
        // Custom cell factory for date column to format the date
        dateCol.setCellFactory(column -> new TableCell<Donation, LocalDate>() {
            @Override
            protected void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                if (empty || date == null) {
                    setText(null);
                } else {
                    setText(date.format(DateTimeFormatter.ofPattern("MMM dd, yyyy")));
                }
            }
        });
        
        TableColumn<Donation, String> statusCol = new TableColumn<>("Select");
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));

        bookDonationTable.getColumns().clear();
        bookDonationTable.getColumns().addAll(bloodTypeCol, unitsCol, locationCol, dateCol, statusCol);

        // Add sample data
        ObservableList<Donation> donations = FXCollections.observableArrayList(
            new Donation("A+", 1, "Dhaka", LocalDate.of(2024, 1, 15), "Pending"),
            new Donation("B-", 2, "Chittagong", LocalDate.of(2024, 2, 20), "Approved"),
            new Donation("O+", 1, "Sylhet", LocalDate.of(2024, 3, 10), "Pending"),
            new Donation("AB+", 3, "Khulna", LocalDate.of(2024, 4, 5), "Approved"),
            new Donation("A-", 1, "Rajshahi", LocalDate.of(2024, 5, 1), "Pending"),
            new Donation("B+", 2, "Barisal", LocalDate.of(2024, 6, 12), "Approved")
        );
        
        // Limit to 5 rows
        bookDonationTable.setItems(FXCollections.observableArrayList(donations.subList(0, Math.min(donations.size(), 5))));
        
        // Set column widths (percentage-based)
        bloodTypeCol.prefWidthProperty().bind(bookDonationTable.widthProperty().multiply(0.2));
        unitsCol.prefWidthProperty().bind(bookDonationTable.widthProperty().multiply(0.15));
        locationCol.prefWidthProperty().bind(bookDonationTable.widthProperty().multiply(0.25));
        dateCol.prefWidthProperty().bind(bookDonationTable.widthProperty().multiply(0.25));
        statusCol.prefWidthProperty().bind(bookDonationTable.widthProperty().multiply(0.15));
    }
    
    private void initializeAvailableBloodTable() {
        // Initialize table columns
        TableColumn<BloodAvailability, String> bloodTypeCol = new TableColumn<>("Blood Type");
        bloodTypeCol.setCellValueFactory(new PropertyValueFactory<>("bloodType"));

        TableColumn<BloodAvailability, String> locationCol = new TableColumn<>("Location");
        locationCol.setCellValueFactory(new PropertyValueFactory<>("location"));

        TableColumn<BloodAvailability, Integer> unitsCol = new TableColumn<>("Units");
        unitsCol.setCellValueFactory(new PropertyValueFactory<>("units"));

        availableBloodTable.getColumns().clear();
        availableBloodTable.getColumns().addAll(bloodTypeCol, locationCol, unitsCol);

        // Add sample data
        ObservableList<BloodAvailability> bloodAvailability = FXCollections.observableArrayList(
            new BloodAvailability("A+", "Central Hospital", 15),
            new BloodAvailability("O-", "City Medical Center", 8),
            new BloodAvailability("B+", "University Hospital", 12),
            new BloodAvailability("AB-", "General Hospital", 5),
            new BloodAvailability("A+", "Evercare Hospital", 10),
            new BloodAvailability("O+", "Square Hospital", 7)
        );
        
        // Limit to 5 rows
        availableBloodTable.setItems(FXCollections.observableArrayList(bloodAvailability.subList(0, Math.min(bloodAvailability.size(), 5))));
        
        // Set column widths (percentage-based)
        bloodTypeCol.prefWidthProperty().bind(availableBloodTable.widthProperty().multiply(0.25));
        locationCol.prefWidthProperty().bind(availableBloodTable.widthProperty().multiply(0.5));
        unitsCol.prefWidthProperty().bind(availableBloodTable.widthProperty().multiply(0.25));
    }
    
    private void initializeDonationStats() {
        // Set donation statistics
        totalDonationCount.setText("3");
        lastDonationInfo.setText("A(+ ve)\n2 months ago");
    }
    
    private void initializeBadges() {
        int totalDonations = Integer.parseInt(totalDonationCount.getText());

        // Badge 1: Obtained if totalDonations >= 1
        if (totalDonations >= 1) {
            badge1.setImage(new javafx.scene.image.Image(getClass().getResourceAsStream("/img/badge1_obtained.png")));
        } else {
            badge1.setImage(new javafx.scene.image.Image(getClass().getResourceAsStream("/img/badge1_not_obtain.png")));
        }

        // Badge 2: Obtained if totalDonations >= 5
        if (totalDonations >= 5) {
            badge2.setImage(new javafx.scene.image.Image(getClass().getResourceAsStream("/img/badge2_obtained.png")));
        } else {
            badge2.setImage(new javafx.scene.image.Image(getClass().getResourceAsStream("/img/badge2_not_obtain.png")));
        }
    }
    
    @FXML
    private void handleUpdateStatus() {
        // Handle status update logic
        System.out.println("Update status clicked");
    }
    
    @FXML
    private void handleUpdateLocation() {
        // Handle location update logic
        System.out.println("Update location clicked");
    }

    @FXML
    private void handleBadgeClick(javafx.scene.input.MouseEvent event) {
        ImageView clickedBadge = (ImageView) event.getSource();
        javafx.scene.image.Image fullImage = clickedBadge.getImage();

        // Create a new stage (window) to display the full-resolution image
        javafx.stage.Stage stage = new javafx.stage.Stage();
        javafx.scene.image.ImageView fullImageView = new javafx.scene.image.ImageView(fullImage);
        javafx.scene.Scene scene = new javafx.scene.Scene(new javafx.scene.layout.StackPane(fullImageView));
        stage.setScene(scene);
        stage.setTitle("Badge Image");
        stage.show();
    }
    
    private void initializeAdSlideshow() {
        // Set initial ad image
        updateAdImage();
        
        // Create automatic slideshow with 5 second intervals
        slideShowTimeline = new Timeline(new KeyFrame(Duration.seconds(5), e -> nextAd()));
        slideShowTimeline.setCycleCount(Timeline.INDEFINITE);
        slideShowTimeline.play();
    }
    
    private void updateAdImage() {
        String imagePath = adImages.get(currentAdIndex);
        adImageView.setImage(new Image(getClass().getResourceAsStream(imagePath)));
    }
    
    @FXML
    private void nextAd() {
        currentAdIndex = (currentAdIndex + 1) % adImages.size();
        updateAdImage();
    }
    
    @FXML
    private void previousAd() {
        currentAdIndex = (currentAdIndex - 1 + adImages.size()) % adImages.size();
        updateAdImage();
    }
    
    @FXML
    private void handleAdImageClick(javafx.scene.input.MouseEvent event) {
        // Pause the slideshow when viewing the full image
        slideShowTimeline.pause();
        
        // Get the current ad image
        Image fullImage = adImageView.getImage();
        
        // Create a new stage (window) to display the full-resolution image
        javafx.stage.Stage stage = new javafx.stage.Stage();
        javafx.scene.image.ImageView fullImageView = new javafx.scene.image.ImageView(fullImage);
        
        // Make the image fit the screen while maintaining aspect ratio
        fullImageView.setPreserveRatio(true);
        fullImageView.fitWidthProperty().bind(stage.widthProperty().multiply(0.8));
        fullImageView.fitHeightProperty().bind(stage.heightProperty().multiply(0.8));
        
        javafx.scene.Scene scene = new javafx.scene.Scene(new javafx.scene.layout.StackPane(fullImageView));
        stage.setScene(scene);
        stage.setTitle("Announcements");
        
        // Resume slideshow when the window is closed
        stage.setOnHidden(e -> slideShowTimeline.play());
        
        // Set initial size
        stage.setWidth(800);
        stage.setHeight(600);
        stage.show();
    }
    
    // Inner class for blood availability
    public static class BloodAvailability {
        private String bloodType;
        private String location;
        private int units;
        
        public BloodAvailability(String bloodType, String location, int units) {
            this.bloodType = bloodType;
            this.location = location;
            this.units = units;
        }
        
        public String getBloodType() { return bloodType; }
        public void setBloodType(String bloodType) { this.bloodType = bloodType; }
        
        public String getLocation() { return location; }
        public void setLocation(String location) { this.location = location; }
        
        public int getUnits() { return units; }
        public void setUnits(int units) { this.units = units; }
    }
}