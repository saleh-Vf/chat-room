package models;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.ArrayList;

public class SingelSocket {
    static SingelSocket singelSocket;
    static Socket socket;

    private SingelSocket() throws IOException {
        this.socket = new Socket("141.11.0.80", 8001);
    }

    public static SingelSocket getSingelSocket() throws IOException {
        if (singelSocket == null) singelSocket = new SingelSocket();
        return singelSocket;
    }

    public static void getMessages() throws IOException, ClassNotFoundException {
//        ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
//        ArrayList<Message> messages = (ArrayList<Message>) objectInputStream.readObject();
//        System.out.println(messages.size());
//
//        if (messages != null) {
//            for (Message message : messages) {
//                System.out.println(message.getOwner() + ":\t" + message.getContent());
//            }
//        }
    }

    public static Socket getSocket() {
        return socket;
    }
}
