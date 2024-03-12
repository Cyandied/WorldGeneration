module main.worldgeneration {
    requires javafx.controls;
    requires javafx.fxml;


    opens main.worldgeneration to javafx.fxml;
    exports main.worldgeneration;
}