package org.example.client_graphic;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import models.User;

public class loginController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField name;

    @FXML
    void LoginSubmit(ActionEvent event) throws IOException {
        new User(name.getText());
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("chat_page.fxml"));
        Scene main = new Scene(fxmlLoader.load(), 320, 240);
        main.getStylesheets().add(getClass().getResource("styles/main.css").toExternalForm());
        HelloApplication.stage.setTitle(name.getText());
        HelloApplication.stage.setScene(main);



    }

    @FXML
    void initialize() {
        assert name != null : "fx:id=\"name\" was not injected: check your FXML file 'login.fxml'.";

    }

}
