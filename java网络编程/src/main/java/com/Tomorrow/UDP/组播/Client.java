package com.Tomorrow.UDP.组播;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        DatagramSocket datagramSocket = new DatagramSocket();

        while (true) {
            String s=scanner.nextLine();
            byte[] bytes = s.getBytes();
            InetAddress localHost = InetAddress.getByName("224.0.1.1");
            DatagramPacket datagramPacket = new DatagramPacket(bytes,bytes.length,localHost,10202);
            datagramSocket.send(datagramPacket);
            if(s.equals("bye")){
                break;
            }
        }
        datagramSocket.close();
    }
}
