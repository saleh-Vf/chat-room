import models.GetMessage;
import models.Message;
import models.SendMessage;
import models.SingelSocket;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        SingelSocket singelSocket = SingelSocket.getSingelSocket();
        Socket socket = singelSocket.getSocket();


        ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
        ArrayList<Message> messages = (ArrayList<Message>) objectInputStream.readObject();

        Scanner scanner = new Scanner(System.in);

        if (messages != null){
            for (Message message : messages){
                System.out.println(message.getOwner()+":\t"+message.getContent());
            }
        }

            GetMessage getMessage = new GetMessage();
            SendMessage sendMessage = new SendMessage();

            getMessage.start();
            sendMessage.start();

    }

}
