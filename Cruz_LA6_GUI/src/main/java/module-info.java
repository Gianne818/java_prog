module org.example.cruz_la6_gui {
    requires javafx.controls;
    requires javafx.fxml;

    exports org.example.cruz_la6_gui.item_2 to javafx.graphics;
    opens org.example.cruz_la6_gui.item_2 to javafx.fxml;

    exports org.example.cruz_la6_gui.item_1 to javafx.graphics;
    opens org.example.cruz_la6_gui.item_1 to javafx.fxml;

    exports org.example.cruz_la6_gui.item_9 to javafx.graphics;
    opens org.example.cruz_la6_gui.item_9 to javafx.fxml;
}