package models;

import java.net.Socket;
import java.util.ArrayList;

public class Database {
    private static Database database ;
    private ArrayList<Socket> sockets = null;
    private ArrayList<Message> messages = null;
//    users

    Database(){
        this.messages = new ArrayList<>();
        sockets = new ArrayList<>();

    }
    static Database getDatabase(){
        if (database==null) database = new Database();
        return database;
    }



    public ArrayList<Socket> getSockets() {
//        System.out.println(sockets.size());
        return sockets;
    }

    public  void setSockets(Socket socket) {
        sockets.add(socket);
    }

    public ArrayList<Message> getMessages() {
        return messages;
    }
    public void removeSocket(Socket failedSocket){
        this.sockets.remove(failedSocket);
    }

    public void setMessages(Message message) {
        this.messages.add(message);
    }
}
