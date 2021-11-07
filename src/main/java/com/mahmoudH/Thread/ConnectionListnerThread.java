package com.mahmoudH.Thread;

import com.mahmoudH.Exception.HTTPConfigrationException;
import com.mahmoudH.configreations.Configuration;

import java.net.ServerSocket;
import java.net.Socket;

public class ConnectionListnerThread extends Thread{
    Configuration configuration;
    public ConnectionListnerThread(Configuration c) {
        this.configuration =c;
    }

    @Override
    public void run() {
        try {
            ServerSocket serverSocket=new ServerSocket(configuration.getPort());
            while(true){
                Socket s=serverSocket.accept();
                new HttpHandlerThread(s).start();
            }
        }catch (Exception e){
            throw new HTTPConfigrationException(e);
        }
    }
}
