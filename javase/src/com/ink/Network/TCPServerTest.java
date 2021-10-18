package com.ink.Network;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author ink
 * @date 2021年08月06日15:24
 */
public class TCPServerTest {
//    服务端
    public static void main(String[] args) {
        ServerSocket serversocket = null;
        Socket accept = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        try {
//            服务端地址
            serversocket = new ServerSocket(12345);
//            监听客户端连接，accept即客户端创建的socket
            accept = serversocket.accept();
//            使用字节流读取客户端的消息
            is = accept.getInputStream();
//            直接读入数据存在问题
//            如果读入的是中文信息，并且最后长度超过数组长度，就会乱码
//            所以需要用管道流包装一下
//            byte[] buffer = new byte[1024];
//            int len;
//            while((len = is.read(buffer)) != -1){
//                String msg = new String(buffer, 0, len);
//                System.out.println(msg);
//            }
//            管道流包装
            baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len;
            while((len = is.read(buffer)) != -1){
                baos.write(buffer,0,len);
            }
//            避免乱码
            System.out.println(baos);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
//            关闭i资源
            if(baos != null){
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(accept != null){
                try {
                    accept.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(serversocket != null){
                try {
                    serversocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
