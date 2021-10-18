package com.ink.Thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ink
 * @date 2021年08月04日20:39
 */
public class TestLock {
    public static void main(String[] args) {
        LockTest lockTest = new LockTest();
        new Thread(lockTest,"ink").start();
        new Thread(lockTest,"yinke").start();
        new Thread(lockTest,"inke").start();
    }
}

class LockTest implements Runnable{

    private int ticketNums = 10;

//    定义Lock锁
    private final ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while(true){
            try {
//            加锁
                lock.lock();
                if(ticketNums > 0){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "拿到" +ticketNums--);
                }
                else {
                    break;
                }
            } finally {
//                解锁
                lock.unlock();
            }
        }
    }
}
