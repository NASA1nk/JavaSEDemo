package com.ink.Thread;

/**
 * @author ink
 * @date 2021年08月03日19:50
 */
public class StateTest {
    public static void main(String[] args) throws InterruptedException {
//        Thread类实现了Runnable接口
        Thread thread = new Thread( () -> {
//            线程体
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("结束");
        });
//        查看线程状态
        Thread.State state = thread.getState();
//        NEW
        System.out.println(state);

//        启动线程
        thread.start();
        state = thread.getState();
//        RUNNABLE
        System.out.println(state);

        while (state != Thread.State.TERMINATED){
            Thread.sleep(100);
            state = thread.getState();
            System.out.println(state);
        }
    }
}
