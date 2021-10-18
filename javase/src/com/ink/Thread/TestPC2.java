package com.ink.Thread;

/**
 * @author ink
 * @date 2021年08月05日11:19
 */
public class TestPC2 {
    public static void main(String[] args) {
        Tv tv = new Tv();
        new Player(tv).start();
        new Wathcher(tv).start();
    }
}

class Player extends Thread{
    Tv tv;

    public Player(Tv tv) {
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            if(i%2==0){
                this.tv.play("buaa");
            }else{
                this.tv.play("neau");
            }
        }
    }
}

class Wathcher extends Thread{
    Tv tv;
    public Wathcher(Tv tv){
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            tv.watch();
        }
    }
}

class Tv{
//    表演节目
    String voice;
//    标志位
//    演员表演,观众等待  T
//    观众观看,演员等待  F
    boolean flag = true;

//    表演
    public synchronized void play(String voice){
        if(!flag){
//            观众观看,演员等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("演员表演 : " + voice);
//        通知唤醒
        this.notifyAll();
        this.voice = voice;
//        修改标志位
        this.flag = !flag;
    }

//    观看
    public synchronized void watch(){
        if (flag){
//            演员表演,观众等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("观众观看 : " + voice);
//        通知唤醒
        this.notifyAll();
//        修改标志位
        this.flag = !this.flag;
    }
}
