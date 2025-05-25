package models;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class GetMessage extends Thread {
    Socket currentSocket = null;

    public GetMessage(Socket currentSocket) throws IOException {
        this.currentSocket = currentSocket;
    }


    @Override
    public void run() {
        Database database = Database.getDatabase();
        ArrayList<Socket> sockets = database.getSockets();

        try {
            while (true) {
                if (!this.currentSocket.isClosed()) {

                    ObjectInputStream objectInputStream = new ObjectInputStream(this.currentSocket.getInputStream());
                    Message message = (Message) objectInputStream.readObject();
                    database.setMessages(message);

                    for (Socket socket : sockets) {
                        ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                        objectOutputStream.writeObject(message);
                    }

                }
            }


        } catch (IOException e) {
            database.removeSocket(currentSocket);
        } catch (ClassNotFoundException e) {
            database.removeSocket(currentSocket);
        }

    }
}
