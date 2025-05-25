package models;

import java.io.IOException;
import java.net.Socket;

public class SingelSocket {
    static SingelSocket singelSocket;
    static Socket socket ;
    SingelSocket() throws IOException {
        this.socket = new Socket("localhost",8001);
    }

    public static SingelSocket getSingelSocket() throws IOException {
        if (singelSocket==null) singelSocket = new SingelSocket();
        return singelSocket;
    }

    public static Socket getSocket() {
        return socket;
    }
}
