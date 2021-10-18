package com.ink.Thread;

/**
 * @author ink
 * @date 2021年08月04日10:56
 */
public class SafeTicket {
    public static void main(String[] args) {
        BuyTicket buyTicket = new BuyTicket();
        new Thread(buyTicket,"ink").start();
        new Thread(buyTicket,"yinke").start();
        new Thread(buyTicket,"inke").start();
    }
}

class BuyTicket implements Runnable{
    private int ticketNums = 10;
    boolean flag = true;

    @Override
    public void run() {
        while(flag){
            try {
                buy();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
//    同步方法
//    锁的是this
    private synchronized void buy() throws InterruptedException {
        if(ticketNums <= 0){
            flag = false;
            return ;
        }
//        模拟延时
        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName() + "拿到" + ticketNums + "张票");
        ticketNums--;

    }
}
