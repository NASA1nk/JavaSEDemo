package com.ink.Thread;

/**
 * @author ink
 * @date 2021年08月02日16:49
 */
public class Ticket implements Runnable{
    private int ticketNums = 10;

    @Override
    public void run() {
        while(true){
            if(ticketNums <= 0){
                break;
            }
//            模拟延时
//            try {
//                Thread.sleep(200);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            System.out.println(Thread.currentThread().getName() + "-拿到了第" + ticketNums-- + "张票");
        }
    }

    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        new Thread(ticket,"ink").start();
        new Thread(ticket,"yinke").start();
        new Thread(ticket,"inke").start();
    }
}
