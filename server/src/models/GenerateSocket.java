package models;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

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
                ObjectOutputStream outputStream = new ObjectOutputStream(this.currentSocket.getOutputStream());
                outputStream.writeObject(database.getMessages());

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
