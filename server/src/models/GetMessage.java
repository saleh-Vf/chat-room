package models;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class GetMessage extends Thread {
//    GenerateSocket generateSocket = new GenerateSocket();
//    private Socket currentSocket = generateSocket.getCurrentSocket();
    Socket currentSocket = null;

    public GetMessage(Socket currentSocket) throws IOException {
        this.currentSocket = currentSocket;
    }


    @Override
    public void run() {
        Database database = Database.getDatabase();
        ArrayList<Socket> sockets =database.getSockets();

        try {
//            DataInputStream dataInputStream = new DataInputStream(this.socket.getInputStreamputStream());
//                    System.out.println(database.getSockets().size());
            while (true) {

                    ObjectInputStream objectInputStream = new ObjectInputStream(this.currentSocket.getInputStream());
                    Message message = (Message) objectInputStream.readObject();
                    database.setMessages(message);

                    for (Socket socket : sockets){
                        ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                        objectOutputStream.writeObject(message);
                    }
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
