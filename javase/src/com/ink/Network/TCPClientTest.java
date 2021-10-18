package com.ink.Network;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author ink
 * @date 2021年08月06日15:24
 */
public class TCPClientTest {
//    客户端
    public static void main(String[] args) {
        Socket socket = null;
        OutputStream os = null;
        try {
//        获取服务端的IP:PORT
            InetAddress serverIp = InetAddress.getByName("127.0.0.1");
            int port = 12345;
//            创建socket连接
            socket = new Socket(serverIp,port);
//            使用字节流发送信息
            os = socket.getOutputStream();
//            String的getBytes()方法
            os.write("客户端通过TCP连接向服务端发送消息".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
//            关闭资源
            if(os != null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
