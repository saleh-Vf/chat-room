package models;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class SendMessage extends Thread {
    private Message message;


    @Override
    public void run() {
        while (true){
            Scanner sc = new Scanner(System.in);
            String content = sc.nextLine();
            message = new Message("owner",content);

            try {

                ObjectOutputStream objectOutputStream = new ObjectOutputStream(SingelSocket.getSocket().getOutputStream());
                objectOutputStream.writeObject(this.message);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
