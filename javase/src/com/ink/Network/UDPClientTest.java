package com.ink.Network;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClientTest {
    public static void main(String[] args) throws Exception {
//        创建socket
        DatagramSocket socket = new DatagramSocket();
//        创建包
        String msg = "像服务器发送packet";
        InetAddress localhost = InetAddress.getByName("localhost");
        int port = 9090;
//        String转byte[]
//        param:数据,[start,end],发送对象
        DatagramPacket packet = new DatagramPacket(msg.getBytes(), 0, msg.getBytes().length, localhost, port);
//        发送包
        socket.send(packet);
//        关闭资源
        socket.close();
    }
}
