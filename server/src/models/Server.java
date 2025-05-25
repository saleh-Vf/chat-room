package models;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    static ServerSocket serverSocket = null;
    static Server server = null;
    public Server() throws IOException {
        serverSocket =  new ServerSocket(8001);
    }
    public static Server getServer() throws IOException {
        if (server==null) server = new Server();
        return server;
    }

    public static ServerSocket getServerSocket() {
        return serverSocket;
    }
}
