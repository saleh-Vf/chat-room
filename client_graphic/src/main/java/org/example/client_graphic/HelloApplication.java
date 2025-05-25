package org.example.client_graphic;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import models.Message;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.ArrayList;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException, ClassNotFoundException {
//        Socket socket = new Socket("localhost",8001);
//        DataInputStream dataInputStream= new DataInputStream(socket.getInputStream());
//        System.out.println(dataInputStream.readUTF());

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("chat_page.fxml"));

        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(getClass().getResource("styles/main.css").toExternalForm());

        stage.setMaximized(true);
        stage.setResizable(true);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}