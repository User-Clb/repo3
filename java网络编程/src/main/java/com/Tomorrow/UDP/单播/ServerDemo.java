package com.Tomorrow.UDP.单播;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class ServerDemo {
    public static void main(String[] args) throws IOException {
        //1.找码头
        DatagramSocket datagramSocket = new DatagramSocket(10000);
        while (true) {
            //2.创建新箱子
            byte[] bytes =new byte[160];
            DatagramPacket datagramPacket = new DatagramPacket(bytes,bytes.length);
            //3.把礼物装进新箱子
//        System.out.println("*********接收前**********");
            datagramSocket.receive(datagramPacket);
//        System.out.println("*********接收后**********");
            //4.从箱子取出礼物
//        byte[] data = datagramPacket.getData();
            System.out.println(new String(bytes,0,bytes.length).trim());
            if(new String(bytes,0,bytes.length).trim().equals("exit")){
                break;
            }
        }
        //5.释放资源
        datagramSocket.close();

    }
}
