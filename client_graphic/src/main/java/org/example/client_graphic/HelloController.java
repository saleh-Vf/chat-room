package org.example.client_graphic;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.URL;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import models.*;

public class HelloController {
    SingelSocket singelSocket = SingelSocket.getSingelSocket();
    Socket socket = SingelSocket.getSocket();


    //    ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
//    ArrayList<Message> messages = (ArrayList<Message>) objectInputStream.readObject();
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField input;
    @FXML
    private VBox messageContainer;
    @FXML
    private ScrollPane scrollPane;

    public HelloController() throws IOException, ClassNotFoundException {
    }

    @FXML
    void sendMessage(ActionEvent event) throws IOException, ClassNotFoundException {
//        System.out.println("hi");
        Message message = new Message("saleh", input.getText(), LocalTime.now());
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        objectOutputStream.writeObject(message);
        this.input.setText("");

//        SendMessage sendMessage = new SendMessage();
//
//        getMessage.start();
//        sendMessage.start();


//
//        for (int i = 0; i < 10; i++) {
//            try {
//                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("message.fxml"));
//                Parent card = fxmlLoader.load();
//                messageContainer.getChildren().add(card);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }


    }

    @FXML
    void initialize() throws IOException, ClassNotFoundException {
        scrollPane.setFitToWidth(true);
        ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
        ArrayList<Message> messages = (ArrayList<Message>) objectInputStream.readObject();
        if (!messages.isEmpty()) {
            for (Message message : messages) {
                Parent card = MessageCard.createMessageCard(message.getOwner(), message.getContent(),message.getTime());
                messageContainer.getChildren().add(card);
            }
        }

        GetMessage getMessage = new GetMessage(messageContainer);
        getMessage.start();


        assert input != null : "fx:id=\"input\" was not injected: check your FXML file 'chat_page.fxml'.";
        assert scrollPane != null : "fx:id=\"scrollPane\" was not injected: check your FXML file 'chat_page.fxml'.";

    }



}
