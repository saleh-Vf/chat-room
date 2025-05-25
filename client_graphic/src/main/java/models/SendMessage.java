package models;

import java.io.IOException;
import java.io.ObjectOutputStream;

public class SendMessage extends Thread {
    private Message message;


    @Override
    public void run() {
        while (true){
            try {

                ObjectOutputStream objectOutputStream = new ObjectOutputStream(SingelSocket.getSocket().getOutputStream());
                objectOutputStream.writeObject(this.message);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
