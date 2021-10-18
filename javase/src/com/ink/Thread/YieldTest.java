package com.ink.Thread;

/**
 * @author ink
 * @date 2021年08月03日16:41
 */
public class YieldTest {
    public static void main(String[] args) {
        YieldT yieldT = new YieldT();
        new Thread(yieldT,"yinke").start();
        new Thread(yieldT,"ink").start();
    }
}

class YieldT implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "线程开始执行");
//        Thread.yield();
        System.out.println(Thread.currentThread().getName() + "线程停止执行");

    }
}
