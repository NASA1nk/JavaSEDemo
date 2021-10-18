package com.ink.Thread;

/**
 * @author ink
 * @date 2021年08月03日22:10
 */
public class DaemonTest {
    public static void main(String[] args) {
        God god = new God();
        You you = new You();
//        正常的线程都是用户线程
        Thread thread = new Thread(god);
//        设置为守护线程
        thread.setDaemon(true);

        thread.start();
        new Thread(you).start();
    }
}
class God implements Runnable{
    @Override
    public void run() {
        while (true){
            System.out.println("守护线程存在...");
        }
    }
}

class You implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 365; i++) {
            System.out.println("用户线程存在...");
        }
        System.out.println("用户线程结束");
    }
}
