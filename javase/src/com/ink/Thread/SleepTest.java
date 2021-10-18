package com.ink.Thread;

/**
 * @author ink
 * @date 2021年08月03日16:23
 */
public class SleepTest implements Runnable{
    private int ticketNums = 10;

    @Override
    public void run() {
        while(true){
            if(ticketNums <= 0){
                break;
            }
//            模拟网络延时
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "-拿到了第" + ticketNums-- + "张票");
        }
    }

    public static void main(String[] args) {
        SleepTest sleepTest = new SleepTest();
        new Thread(sleepTest,"ink").start();
        new Thread(sleepTest,"yinke").start();
        new Thread(sleepTest,"inke").start();
    }
}
