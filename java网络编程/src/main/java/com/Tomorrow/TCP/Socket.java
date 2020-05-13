package com.Tomorrow.TCP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Scanner;

public class Socket {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        //1.创建Socket对象
        java.net.Socket socket = new java.net.Socket("127.0.0.1", 12222);
        OutputStream outputStream = null;
        while (true) {
            //2.以流的格式写入数据
            String s=scanner.nextLine();
            outputStream = socket.getOutputStream();
            outputStream.write((s+"\n").getBytes());
//            socket.shutdownOutput();
            if(s.equals("bye")){
                socket.shutdownOutput();
                break;
            }
        }

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String line;
        while ((line = bufferedReader.readLine()) != null){
            System.out.println(line);
        }
        //3.关闭Socket,流
        bufferedReader.close();
        outputStream.close();
        socket.close();
    }
}
