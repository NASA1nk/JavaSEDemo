package com.ink.Thread;

/**
 * @author ink
 * @date 2021年08月05日9:15
 */
public class TestPC {
    public static void main(String[] args) {
        SynContainer synContainer = new SynContainer();
//        只适用于一个生产者一个消费者的情况
        new Productor(synContainer).start();
        new Consumer(synContainer).start();
    }
}

//生产者
class Productor extends Thread{
    SynContainer container;

    public Productor(SynContainer container) {
        this.container = container;
    }
//    生产
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            container.push(new Chicken(i));
            System.out.println("生产了第" + i + "只鸡");
        }
    }
}

//消费者
class Consumer extends Thread{
    SynContainer container;

    public Consumer(SynContainer container) {
        this.container = container;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("消费了第" + container.pop().id + "只鸡");
        }
    }
}
//产品
class Chicken{
    int id;
    public Chicken(int id) {
        this.id = id;
    }
}

//缓冲区
class SynContainer {
//    容器大小
    Chicken[] chickens = new Chicken[10];
//    容器计数器
    int count = 0;
//    生产者生产产品
    public synchronized void push(Chicken chicken){
//        如果容器满了,就需要通知消费者,并等待消费者消费
        if(count == chickens.length){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
//        如果容器没有满,就需要生产产品,并通知消费者消费
        chickens[count++] = chicken;
        this.notifyAll();
    }


//    消费者消费产品
    public synchronized Chicken pop(){
//        如果容器空了,就需要通知生产者,并等待生产者生产
        if(count == 0){
            try {
//                释放对象锁权限,让出CPU,唯一的生产者重新拿到锁权限进行生产
                this.wait();
            } catch (InterruptedException e) {
//                TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

//        如果容器非空,就需要消费产品,并通知生产者生产产品
//        count需要先减少才能得到有产品的位置,因为生产者放完后count会++
        count--;
        Chicken chicken = chickens[count];
        this.notifyAll();
        return chicken;
    }
}

