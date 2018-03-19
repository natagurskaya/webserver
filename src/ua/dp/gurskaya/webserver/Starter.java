package ua.dp.gurskaya.webserver;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Starter {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Connected to client");
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                outputStream.write(line.getBytes());
            }
            System.out.println("Disconnected from client");
            outputStream.close();
            inputStream.close();
        }
    }
}
