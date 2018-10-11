package com.net;


import java.io.*;
import java.net.Socket;
import java.net.SocketException;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 3000);

//        OutputStream outputStream = socket.getOutputStream();
        Writer writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        writer.write("Hello\n");
        writer.flush();

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String echo = reader.readLine();
            System.out.println(echo);

            echo = reader.readLine();
            System.out.println(echo);
        }
        catch (SocketException e) {
            System.out.println("Connection reset");
        }


    }

    /*    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 3000);
        InputStream inputStream = socket.getInputStream();

        byte[] buffer = new byte[1024];
        int count = inputStream.read(buffer);
        String messageFromServer = new String(buffer, 0, count);
        System.out.println(messageFromServer);
    }*/
}