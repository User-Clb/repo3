package com.Tomorrow.UDP.单播;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class ClientDemo {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        //1.找码头
        DatagramSocket datagramSocket = new DatagramSocket();
        while (true) {
            String s = scanner.nextLine();
            //2.打包
            byte[] bytes = s.getBytes();
            //获取ip/主机名1
            InetAddress byName = InetAddress.getByName("LAPTOP-6DPO624Q");
//        //获取ip/主机名2
//        String ip="192.168.1.100";
//        String[] ii=ip.split("\\.");
//        byte[] ips=new byte[4];
//        for(int i=0;i<4;i++){
//            ips[i]=(byte)(Integer.parseInt(ii[i]));
//        }
//        System.out.println(InetAddress.getByAddress(ips).getHostName()+"/"+InetAddress.getByAddress(ips).getHostAddress());
//        //获取ip/主机名23
//        String hostAddress1 = InetAddress.getLocalHost().getHostAddress();
//        String hostName1 = InetAddress.getLocalHost().getHostName();
//        System.out.println(hostAddress1+"+"+hostName1);

//            String hostAddress = byName.getHostAddress();
//            System.out.println("hostAddress:" + hostAddress);
//            String hostName = byName.getHostName();//InetAddress.getLocalHost().getHostName()
//            System.out.println("hostName：" + hostName);
//
//            System.out.println("*******************************************");

            int port = 10000;
            DatagramPacket datagramPacket = new DatagramPacket(bytes,bytes.length,byName,port);
            //3.由码头发出
            datagramSocket.send(datagramPacket);
            if("exit".equals(s)){
                break;
            }
        }
        //4.释放资源
        datagramSocket.close();
    }
}
