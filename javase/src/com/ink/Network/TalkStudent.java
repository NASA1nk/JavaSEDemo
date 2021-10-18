package com.ink.Network;

public class TalkStudent {
    public static void main(String[] args) {
//        开启两个线程
//        老师的端口是8888
        new Thread(new TalkSend(7777,"localhost",8888)).start();
        new Thread(new TalkReceive(9999,"老师说")).start();
    }
}
