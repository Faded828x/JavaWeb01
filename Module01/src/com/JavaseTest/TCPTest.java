package com.JavaseTest;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPTest {

    @Test
    public void client() throws IOException {
        //向服务端发送
        Socket socket = new Socket(InetAddress.getByName("192.168.1.5"),9090);
        OutputStream outputStream = socket.getOutputStream();
        FileInputStream fileInputStream = new FileInputStream(new File("No game no life.png"));
        byte[] bytes = new byte[1024];
        int len;
        while((len = fileInputStream.read(bytes))!=-1){
            outputStream.write(bytes,0,len);
        }
        socket.shutdownOutput();
        //从服务端接收
        InputStream inputStream = socket.getInputStream();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bytes1 = new byte[20];
        int len1;
        while((len1=inputStream.read(bytes1))!=-1){
            byteArrayOutputStream.write(bytes1,0,len1);
        }
        System.out.println(byteArrayOutputStream.toString());
        fileInputStream.close();
        outputStream.close();
        socket.close();
        byteArrayOutputStream.close();
    }

    @Test
    public void server() throws IOException {
        //从客户端接收
        ServerSocket serverSocket = new ServerSocket(9090);
        Socket accept = serverSocket.accept();
        InputStream inputStream = accept.getInputStream();
        FileOutputStream fileOutputStream = new FileOutputStream(new File("No game no life1.png"));
        byte[] bytes = new byte[1024];
        int len;
        while((len = inputStream.read(bytes))!=-1){
            fileOutputStream.write(bytes,0,len);
        }
        //向客户端发送
        OutputStream outputStream = accept.getOutputStream();
        outputStream.write("Get".getBytes());
        fileOutputStream.close();
        inputStream.close();
        accept.close();
        serverSocket.close();
        outputStream.close();
    }
}
