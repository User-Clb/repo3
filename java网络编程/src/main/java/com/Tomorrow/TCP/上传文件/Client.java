package com.Tomorrow.TCP.上传文件;

import java.io.*;

import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1",12340);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("C:\\Users\\32046\\Desktop\\优化图片\\Screenshot_2020-03-19-17-45-35-12_waifu2x_5x_3n_png.png"));
        BufferedOutputStream bufferedOutputStream= new BufferedOutputStream(socket.getOutputStream());
        int n = 0;
        while ((n = bufferedInputStream.read())!= -1){
            bufferedOutputStream.write(n);
        }
        bufferedOutputStream.flush();
        socket.shutdownOutput();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String line ;
        while ((line=bufferedReader.readLine())!=null){
            System.out.println(line);
        }

        bufferedInputStream.close();
        bufferedOutputStream.close();
        bufferedReader.close();
        socket.close();

    }
}
