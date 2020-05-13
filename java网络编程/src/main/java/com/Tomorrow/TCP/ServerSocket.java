package com.Tomorrow.TCP;

import java.io.*;
import java.net.Socket;

public class ServerSocket {
    public static void main(String[] args) throws IOException {
        //1.创建Scoket对象
        java.net.ServerSocket serverSocket = new java.net.ServerSocket(12222);
        //2.等待客户端连接
        System.out.println("****连接中****");
        Socket accept = serverSocket.accept();
        System.out.println("**连接成功***");
        InputStream inputStream = null;

        //3.获得输入流
        BufferedReader buffered = new BufferedReader(new InputStreamReader(accept.getInputStream()));
        String line;
        while ((line=buffered.readLine())!=null){
            System.out.println(line);

        }

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(accept.getOutputStream()));
        bufferedWriter.write("再见！");
        bufferedWriter.newLine();
        bufferedWriter.flush();

        //4.释放资源
        serverSocket.close();
        accept.close();
        bufferedWriter.close();
        buffered.close();

    }

}
