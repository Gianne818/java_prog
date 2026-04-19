module org.example.calcujavafxmarch28 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;


    opens org.example.calcujavafxmarch28 to javafx.fxml;
    exports org.example.calcujavafxmarch28;
}