package com.ink.Network;

public class TalkTeacher {
    public static void main(String[] args) {
//        学生的端口是9999
        new Thread(new TalkSend(5555,"localhost",9999)).start();
        new Thread(new TalkReceive(8888,"学生说")).start();
    }
}
