package com.ink.Thread;

/**
 * @author ink
 * @date 2021年08月02日20:10
 */
public class Race implements Runnable{
    public static String winner;
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if(Thread.currentThread().getName().equals("ink") && i%10 == 0){
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            boolean flag = gameOver(i);
            if(flag) {
                break;
            }
            System.out.println(Thread.currentThread().getName() + "跑了" + i + "步");
        }
    }
    private boolean gameOver(int step) {
        if(winner != null) {
            return true;
        }
        if(step >= 100) {
            winner = Thread.currentThread().getName();
            System.out.println("winner is " + winner);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Race race = new Race();
        new Thread(race,"ink").start();
        new Thread(race,"yinke").start();
    }
}
