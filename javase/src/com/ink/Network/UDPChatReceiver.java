package com.ink.Network;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPChatReceiver {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(6666);
        byte[] buffer = new byte[1024];
        while(true){
            DatagramPacket packet = new DatagramPacket(buffer,0,buffer.length);
            socket.receive(packet);
            byte[] datas = packet.getData();
            String data = new String(datas, 0, packet.getLength());
            System.out.println(data);
            if("bye".equals(data)){
                break;
            }
        }
        socket.close();

    }
}
