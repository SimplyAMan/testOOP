package com.net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by dsk1 on 10/11/2018.
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(3000);

        while (true) {
            Socket socket = serverSocket.accept();
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line = reader.readLine();
            System.out.println(line);

            Writer writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            writer.write("Echo - " + line + "\n");
            writer.flush();
            /*writer.write("New echo - " + line + "\n");
            writer.flush();*/
        }

//        InputStream inputStream = socket.getInputStream();
//        byte[] bytes = new byte[1024];
//        System.out.println(inputStream.read(bytes));


    }

    /*public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(3000);
        Socket socket = serverSocket.accept();
        OutputStream outputStream = socket.getOutputStream();

        outputStream.write("Welcome and Goodbye!".getBytes());
    }*/
}