package com.Tomorrow.UDP.组播;

import sun.security.util.Length;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class Server {
    public static void main(String[] args) throws IOException {
        MulticastSocket multicastSocket = new MulticastSocket(10202);
        //加入组播
        multicastSocket.joinGroup(InetAddress.getByName("224.0.1.1"));
        while (true) {
            DatagramPacket datagramPacket = new DatagramPacket(new byte[1024],1024);
            multicastSocket.receive(datagramPacket);
            byte[] data = datagramPacket.getData();
            int length = datagramPacket.getLength();
            System.out.println(new String(data,0,length).trim());
            if (new String(data,0,length).trim().equals("bye")){
                break;
            }
        }
        multicastSocket.close();
    }
}
