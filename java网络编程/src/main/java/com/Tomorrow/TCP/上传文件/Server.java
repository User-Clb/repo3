package com.Tomorrow.TCP.上传文件;

import com.Tomorrow.TCP.ServerSocket;

import java.io.*;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        java.net.ServerSocket serverSocket = new java.net.ServerSocket(12340);
        Socket accpet = serverSocket.accept();
        BufferedInputStream bufferedInputStream = new BufferedInputStream(accpet.getInputStream());
        FileOutputStream fileOutputStream = new FileOutputStream("D:\\DATA\\java网络编程\\上传文件夹\\Screenshot_2020-03-19-17-45-35-12_waifu2x_5x_3n_png.png");
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        int n = 0;
        while ((n =bufferedInputStream.read())!=-1){
            bufferedOutputStream.write(n);
        }
        bufferedOutputStream.flush();

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(accpet.getOutputStream()));
        bufferedWriter.write("上传成功");
        bufferedWriter.newLine();
        bufferedWriter.flush();

        bufferedInputStream.close();
        fileOutputStream.close();
        bufferedOutputStream.close();
        serverSocket.close();
        accpet.close();
        bufferedWriter.close();

    }
}
