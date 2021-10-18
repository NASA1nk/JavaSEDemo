package com.ink.Thread;

/**
 * @author ink
 * @date 2021年08月02日16:16
 */
public class RunnableTest implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("子线程执行" + i);
        }
    }

    public static void main(String[] args) {
        RunnableTest runnableTest = new RunnableTest();
//        Thread thread = new Thread(runnableTest);
//        thread.start();
        new Thread(runnableTest).start();
        for (int i = 0; i < 200; i++) {
            System.out.println("主线程执行" + i);
        }
    }
}
