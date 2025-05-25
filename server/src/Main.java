import models.GenerateSocket;
import models.GetMessage;
import models.Server;

import java.io.IOException;
import java.net.ServerSocket;

public class Main {
    public static void main(String[] args) throws IOException {
        Server server = Server.getServer();
        ServerSocket serverSocket = server.getServerSocket();


//        while(true){
            GenerateSocket generateSocket = new GenerateSocket();
//            SendSocket sendSocket = new SendSocket(socket);


//            sendSocket.start();
            generateSocket.start();
//        }


    }
}