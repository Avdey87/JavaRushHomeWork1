package com.javarush.test.level30.lesson15.big01;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    private static final Map<String, Connection> connectionMap = new ConcurrentHashMap<>();
    public static void main(String[] args) {
        ConsoleHelper.writeMessage("Enter the port");
        int port = ConsoleHelper.readInt();
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            ConsoleHelper.writeMessage("Server is up");
            ConsoleHelper.writeMessage(serverSocket.getInetAddress() + " " + serverSocket);
            while (true) {
                Handler handler = new Handler(serverSocket.accept());
                handler.start();
            }
        } catch (Exception e) {
            ConsoleHelper.writeMessage("mistake");
        }
    }
    public void sendBroadcastMessage(Message message) {
        for (Map.Entry<String, Connection> loop : connectionMap.entrySet()) {
            try {
                loop.getValue().send(message);
            } catch (IOException e) {
                ConsoleHelper.writeMessage("Don't send messaege to " + loop.getKey());
            }
        }
    }
    private static class Handler extends Thread {
        private Socket socket;
        public Handler(Socket socket) {
            this.socket = socket;
        }
    }
}
