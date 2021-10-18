package com.ink.Network;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServerTest {
    public static void main(String[] args) throws Exception {
//        开放端口
        DatagramSocket socket = new DatagramSocket(9090);
//        接受包
        byte[] buffer = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length);
        socket.receive(packet);
        System.out.println(packet.getAddress());
        System.out.println(new String(packet.getData(),0,packet.getLength()));
//        关闭资源
        socket.close();
    }
}
