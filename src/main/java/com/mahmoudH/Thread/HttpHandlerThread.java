package com.mahmoudH.Thread;

import com.mahmoudH.Exception.HTTPConfigrationException;

import java.io.*;
import java.net.Socket;

public class HttpHandlerThread extends Thread {
    Socket socket;
    final String CRLF = "\r\n";


    public HttpHandlerThread(Socket s) {
        this.socket = s;
    }

    @Override
    public void run() {
        try{
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder sb=new StringBuilder();


            String i=in.readLine();
            String s[]=i.split(" ");
            while((i=in.readLine())!=null&&i.length()!=0){
                System.out.println(i);
                sb.append(i);
            }

            String html;
            try{
                html= getHtml("src/main/resources/static"+s[1]+".html");
            }catch(Exception e){
                html= getHtml("src/main/resources/static/Error.html");
            }



            String httpResponse="HTTP/1.1 200 OK"+CRLF
                    +"Content-Length: " + html.getBytes().length + CRLF +
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
