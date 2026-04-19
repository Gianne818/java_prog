module com.example.javafxapril14 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql; // You'll need this for JDBC later

    // Open the main package for the Application class
    opens com.example.javafxapril14 to javafx.fxml, javafx.graphics;

    // Open your screen packages so FXML can find your Controllers
    opens com.example.javafxapril14.screens.login to javafx.fxml;
    opens com.example.javafxapril14.screens.register to javafx.fxml;
    opens com.example.javafxapril14.screens.landing to javafx.fxml;

    // Export the root package
    exports com.example.javafxapril14;
}