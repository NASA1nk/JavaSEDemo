package com.ink.Thread;
/**
 * @author ink
 * @date 2021年08月09日13:06
 */
public class SynObj {
    public synchronized void methodA() {
        System.out.println("methodA.....");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public  void methodB() {
        synchronized(this) {
            System.out.println("methodB.....");
        }
    }

    public void methodC() {
        String str = "sss";
        synchronized (str) {
            System.out.println("methodC.....");
        }
    }
}
