package models;

import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.io.ObjectInputStream;

public class GetMessage extends Thread {
    VBox vbox;

    public GetMessage(VBox vbox) {
        this.vbox = vbox;
    }

    @Override
    public void run() {
        while (true) {
            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(SingelSocket.getSocket().getInputStream());
                Message message = (Message) objectInputStream.readObject();
                System.out.println(message.getOwner() + ":\t" + message.getContent());
                Parent card = MessageCard.createMessageCard(message.getOwner(), message.getContent(),message.getTime());

                Platform.runLater(() -> {
                    vbox.getChildren().add(card);
                });

            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
