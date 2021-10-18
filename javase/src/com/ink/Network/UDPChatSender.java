package com.ink.Network;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class UDPChatSender {
    public static void main(String[] args) throws Exception  {
        DatagramSocket socket = new DatagramSocket();
//        控制台读取System.in
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String data = reader.readLine();
            byte[] datas = data.getBytes();
            DatagramPacket packet = new DatagramPacket(datas,0,datas.length,new InetSocketAddress("localhost",6666));
            socket.send(packet);
            if("bye".equals(data)){
                break;
            }
        }
        socket.close();
    }
}
