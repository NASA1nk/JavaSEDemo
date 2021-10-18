package com.ink.Thread;

/**
 * @author ink
 * @date 2021年08月04日15:59
 */
public class DeadLock {
    public static void main(String[] args) {
        Makeup hu1 = new Makeup(0, "hu1");
        Makeup hu2 = new Makeup(1, "hu2");
        hu1.start();
        hu2.start();
    }
}

class Mirror1{

}

class Lipstick{

}
class Makeup extends Thread{
//    保证需要的资源只有一份
    static Lipstick lipstick = new Lipstick();
    static Mirror1 mirror = new Mirror1();

    int choice;
    String girlName;

    public Makeup(int choice, String girlName) {
        this.choice = choice;
        this.girlName = girlName;
    }

    @Override
    public void run() {
        try {
            makeup();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void makeup() throws InterruptedException {
        if(choice == 0){
            synchronized (lipstick) {
                System.out.println(this.girlName + "获得口红的锁");

                Thread.sleep(1000);
            }
            synchronized (mirror) {
                System.out.println(this.girlName + "获得镜子的锁");
            }
        }
        else {
            synchronized (mirror) {
                System.out.println(this.girlName + "获得镜子的锁");
                Thread.sleep(1000);
            }
            synchronized (lipstick) {
                System.out.println(this.girlName + "获得口红的锁");
            }
        }
    }
}
