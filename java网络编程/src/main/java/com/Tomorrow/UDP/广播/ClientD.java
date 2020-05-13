package com.Tomorrow.UDP.广播;

import java.io.IOException;
import java.net.*;

public class ClientD {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket();
        String s="hello";
        byte[] bytes = s.getBytes();
        int port = 10290;
        InetAddress byName = InetAddress.getByName("255.255.255.255");
        DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length, byName, port);
        datagramSocket.send(datagramPacket);
        datagramSocket.close();
    }
}
