package org.example.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class ChatClient {

    private static DatagramSocket socket;
    private static InetAddress address;
    private static String identifier;
    private static final int SERVER_PORT = 8000;

    static {
        try {
            socket = new DatagramSocket();
            address = InetAddress.getByName("localhost");
        } catch (SocketException | UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.print("Enter your name: ");
        BufferedReader nameReader = new BufferedReader(new InputStreamReader(System.in));
        identifier = nameReader.readLine();

        ClientThread clientThread = new ClientThread(socket);
        clientThread.start();

        byte[] uuid = ("init;" + identifier).getBytes();
        DatagramPacket initialize = new DatagramPacket(uuid, uuid.length, address, SERVER_PORT);
        socket.send(initialize);

        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while (true) {
            System.out.print("Enter message: ");
            input = userInput.readLine();
            String temp = identifier + ";" + input;
            byte[] msg = temp.getBytes();
            DatagramPacket send = new DatagramPacket(msg, msg.length, address, SERVER_PORT);
            socket.send(send);
        }
    }
}

