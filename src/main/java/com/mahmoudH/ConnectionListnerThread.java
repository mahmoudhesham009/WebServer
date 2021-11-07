package com.mahmoudH;

import com.mahmoudH.Exception.HTTPConfigrationException;
import com.mahmoudH.configreations.Configration;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ConnectionListnerThread extends Thread{
    Configration configration;
    public ConnectionListnerThread(Configration c) {
        this.configration=c;
    }

    @Override
    public void run() {
        try {
            ServerSocket serverSocket=new ServerSocket(configration.getPort());
            while(true){
                Socket s=serverSocket.accept();
                new HttpHandlerThread(s).start();
            }
        }catch (Exception e){
            throw new HTTPConfigrationException(e);
        }
    }
}
