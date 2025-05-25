package models;

import com.sun.tools.javac.Main;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class GenerateSocket extends Thread {
    private ServerSocket serverSocket = Server.getServer().getServerSocket();
    private Database database = Database.getDatabase();
    private Socket currentSocket;

    public GenerateSocket() throws IOException {

    }

    @Override
    public void run() {
        while (true){
            try {
                this.currentSocket = serverSocket.accept();
                database.setSockets(currentSocket);
//                Message message = new Message("saleh","salam");
//                database.setMessages(message);
                if (!database.getMessages().isEmpty()) {
                    ObjectOutputStream outputStream = new ObjectOutputStream(this.currentSocket.getOutputStream());
                    outputStream.writeObject(database.getMessages());
                }
                else {
                    ObjectOutputStream outputStream = new ObjectOutputStream(this.currentSocket.getOutputStream());
                    ArrayList<Message> messages = new ArrayList<>();
                    outputStream.writeObject(messages);
                }
//                DataOutputStream dataOutputStream = new DataOutputStream(currentSocket.getOutputStream());
//                dataOutputStream.writeUTF("salam");
                System.out.println("ok");

                GetMessage getSocket = new GetMessage(currentSocket);
                getSocket.start();


            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        }
    }

    public Socket getCurrentSocket() {
        return currentSocket;
    }
}
