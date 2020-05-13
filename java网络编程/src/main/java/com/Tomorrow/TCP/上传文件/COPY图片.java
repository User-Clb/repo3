package com.Tomorrow.TCP.上传文件;

import java.io.*;

public class COPY图片 {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\32046\\Desktop\\优化图片\\Screenshot_2020-03-19-17-45-35-12_waifu2x_5x_3n_png.png");
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        FileOutputStream fileOutputStream = new FileOutputStream("D:\\DATA\\java网络编程\\上传文件夹\\Screenshot_2020-03-19-17-45-35-12_waifu2x_5x_3n_png.png");
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        int n = 0;
        while ((n =bufferedInputStream.read())!=-1){
            bufferedOutputStream.write(n);
        }
        bufferedOutputStream.flush();

        fileInputStream.close();
        bufferedInputStream.close();
        fileOutputStream.close();
        bufferedOutputStream.close();
    }
}
