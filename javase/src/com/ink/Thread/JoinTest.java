package com.ink.Thread;

/**
 * @author ink
 * @date 2021年08月03日17:02
 */
public class JoinTest implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            System.out.println("join VIP线程" + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        JoinTest joinTest = new JoinTest();
//        代理
        Thread thread = new Thread(joinTest);
        thread.start();

//        主线程
        for (int i = 0; i < 500; i++) {
            if(i == 100){
//                插队，阻塞主线程
                thread.join();
            }
            System.out.println("main方法主线程" + i);
        }
    }
}
