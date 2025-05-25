package models;

import com.sun.tools.javac.Main;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class GetMessage extends Thread {
    @Override
    public void run() {
        while (true){
            try {
            ObjectInputStream objectInputStream = new ObjectInputStream(SingelSocket.getSocket().getInputStream());
            Message message = (Message) objectInputStream.readObject();
            System.out.println(message.getOwner()+":\t"+message.getContent());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        }
    }
}
