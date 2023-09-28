package org.example.server;

import java.io.IOException;
import java.net.*;
import java.util.ArrayList;

public class ChatServer {

    private static byte[] incoming = new byte[256];
    private static final int PORT = 8000;
    private static DatagramSocket socket;

    // create Datagram socket on this port
    static {
        try {
            socket = new DatagramSocket(PORT);
        } catch (SocketException e) {
            throw new RuntimeException(e);
        }
    }

    private static ArrayList<Integer> users = new ArrayList<>();

    private static final InetAddress address;

    static {
        try {
            address = InetAddress.getByName("localhost"); // change to ip adress or domain name to send over the network
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] args) {

        System.out.println("Server started on port " + PORT);

        while (true) {
            DatagramPacket packet = new DatagramPacket(incoming, incoming.length); // prepare packet
            try {
                socket.receive(packet); // receive packet
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            String message = new String(packet.getData(), 0, packet.getLength()); // create a string
            System.out.println("Server received: " + message);


            if (message.contains("init;")) {
                users.add(packet.getPort()); // add the users port to users list
            }
            // forward
            else {
                int userPort = packet.getPort();  // get port from the packet
                byte[] byteMessage = message.getBytes(); // convert the string to bytes

                // forward to all other users except the one who sent the message
                for (int forward_port : users) {
                    if (forward_port != userPort) {
                        DatagramPacket forward = new DatagramPacket(byteMessage, byteMessage.length, address, forward_port);
                        try {
                            socket.send(forward);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }


        }
    }
}