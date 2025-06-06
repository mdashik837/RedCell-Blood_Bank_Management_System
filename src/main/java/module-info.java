module com.redcell {
    requires javafx.controls;
    requires javafx.fxml;
    
    opens com.redcell to javafx.fxml;
    exports com.redcell;
} 