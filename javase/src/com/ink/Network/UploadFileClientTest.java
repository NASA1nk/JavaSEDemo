package com.ink.Network;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author ink
 * @date 2021年10月12日22:37
 */
public class UploadFileClientTest {
    public static void main(String[] args) throws Exception {
//        创建socket连接
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 9000);
//        创建输出流
        OutputStream os = socket.getOutputStream();
//        用文件流读取文件，相对路径是相对项目javase下的
        FileInputStream fis = new FileInputStream(new File("ink.txt"));
//        写出文件
        byte[] buffer = new byte[1024];
        int len;
        while((len = fis.read(buffer))!= -1){
            os.write(buffer,0,len);
        }
//        通知服务器，上传完成
        socket.shutdownOutput();

//        确定服务端接收完成，断开连接
//        获取输入流
        InputStream is = socket.getInputStream();
//        创建管道流
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
//        写出文件
        byte[] buffer2 = new byte[1024];
        int len2;
        while((len2 = is.read(buffer2))!= -1){
            baos.write(buffer2,0,len2);
        }
        System.out.println(baos);
//        关闭资源
        baos.close();
        is.close();
        fis.close();
        os.close();
        socket.close();
    }
}
