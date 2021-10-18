package com.ink.Thread;

/**
 * @author ink
 * @date 2021年08月02日14:59
 */
public class TestThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("线程执行-" + i);
        }
    }

    public static void main(String[] args) {
        TestThread testThread1 = new TestThread();
        testThread1.run();
        System.out.println("start调用");
        testThread1.start();

        for (int i = 0; i < 200; i++) {
            System.out.println("线程-" + i);
        }
    }
}
