package com.ink.Thread;

/**
 * @author ink
 * @date 2021年08月03日21:42
 */
public class PriorityTest implements Runnable{
    @Override
    public void run() {
        System.out.println("当前线程"+Thread.currentThread().getName() +"优先级为"+ Thread.currentThread().getPriority());
    }

    public static void main(String[] args) {
//        主线程默认优先级
        System.out.println("主线程"+Thread.currentThread().getName() +"优先级为"+ Thread.currentThread().getPriority());

        PriorityTest priorityTest = new PriorityTest();

        Thread thread01 = new Thread(priorityTest,"01");
        Thread thread02 = new Thread(priorityTest,"02");
        Thread thread03 = new Thread(priorityTest,"03");
        Thread thread04 = new Thread(priorityTest,"04");
        Thread thread05 = new Thread(priorityTest,"05");
        Thread thread06 = new Thread(priorityTest,"06");

        thread01.start();
//        10
        thread02.setPriority(Thread.MAX_PRIORITY);
        thread02.start();

        thread03.setPriority(6);
        thread03.start();

        thread04.setPriority(5);
        thread04.start();

        thread05.setPriority(-1);
        thread05.start();

        thread05.setPriority(11);
        thread05.start();
    }
}
