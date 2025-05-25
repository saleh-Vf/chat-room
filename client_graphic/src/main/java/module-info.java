module org.example.client_graphic {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.client_graphic to javafx.fxml;
    exports org.example.client_graphic;
}