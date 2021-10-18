package com.ink.Thread;

/**
 * @author ink
 * @date 2021年08月09日13:06
 */
public class SynTest {
    public static void main(String[] args) {
        final SynObj obj = new SynObj();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                obj.methodA();
            }
        });
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                obj.methodB();
            }
        });
        t2.start();

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                obj.methodC();
            }
        });
        t3.start();
    }
}
