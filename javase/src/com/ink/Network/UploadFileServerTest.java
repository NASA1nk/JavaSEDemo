package com.ink.Network;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author ink
 * @date 2021年10月12日22:34
 */
public class UploadFileServerTest {
    public static void main(String[] args) throws IOException {
//        创建服务端口
        ServerSocket serverSocket = new ServerSocket(9000);
//        监听客户端的连接
        Socket accept = serverSocket.accept();
//        获取输入流
        InputStream is = accept.getInputStream();
//        输出文件
        FileOutputStream fos = new FileOutputStream(new File("receive.txt"));
        byte[] buffer = new byte[1024];
        int len;
        while((len = is.read(buffer)) != -1){
            fos.write(buffer,0,len);
        }
//        通知客户端接收完成
//        创建输出流
        OutputStream os = accept.getOutputStream();
        os.write("接收完成，可以断开连接了".getBytes());
//        关闭资源
        os.close();
        fos.close();
        is.close();
        accept.close();
    }
}
