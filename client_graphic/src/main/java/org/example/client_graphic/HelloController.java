package org.example.client_graphic;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;

public class HelloController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField input;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    void sendMessage(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert input != null : "fx:id=\"input\" was not injected: check your FXML file 'chat_page.fxml'.";
        assert scrollPane != null : "fx:id=\"scrollPane\" was not injected: check your FXML file 'chat_page.fxml'.";

    }

}
