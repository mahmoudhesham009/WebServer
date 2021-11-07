package com.mahmoudH;

import com.mahmoudH.Exception.HTTPConfigrationException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class HttpHandlerThread extends Thread {
    Socket socket;
    final String CRLF = "\r\n"; // 13, 10


    public HttpHandlerThread(Socket s) {
        this.socket = s;
    }

    @Override
    public void run() {
        try{
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            StringBuilder sb=new StringBuilder();


            String html= getHtml("src/main/resources/index.html");

            String httpResponse="HTTP/1.1 200 OK"+CRLF
                    +"Content-Length: " + html.getBytes().length + CRLF + // HEADER
                    CRLF +
                    html +
                    CRLF + CRLF;;


            outputStream.write(httpResponse.getBytes());
            socket.close();
        }catch (Exception e){
            throw new HTTPConfigrationException(e);
        }

    }

    private String getHtml(String fileAddress) throws Exception {
        FileReader f=new FileReader(fileAddress);
        int i;
        StringBuilder sb=new StringBuilder();
        while((i=f.read())>-1) {
            sb.append((char)i);
        }
        return sb.toString();
    }
}
