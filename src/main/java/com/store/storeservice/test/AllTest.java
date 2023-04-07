package com.store.storeservice.test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class AllTest {
    public static void main(String[] args) {
//        Screen.in();

    }

//    xml
//    可扩展标记性语言

//    --------------------通信协议---------------------
    private void client() throws IOException{
        Socket socket=new Socket("127.0.0.1",8000);
        OutputStream sps=socket.getOutputStream();
        DataOutputStream dop=new DataOutputStream(sps);
        dop.writeUTF("哈哈哈");
        dop.close();
        sps.close();
        socket.close();
    }
    private void service() throws IOException {
        ServerSocket serviceSocket=new ServerSocket(8000);
        Socket socket=serviceSocket.accept();
        InputStream inputStream=socket.getInputStream();
        DataInputStream dis=new DataInputStream(inputStream);
        String str= dis.readUTF();

        OutputStream outputStream=socket.getOutputStream();
        DataOutputStream dataOutputStream=new DataOutputStream(outputStream);
        dataOutputStream
                .writeUTF("回应");
        dataOutputStream.close();
        outputStream.close();
        dis.close();
        inputStream.close();
        socket.close();
        serviceSocket.close();
    }
}
