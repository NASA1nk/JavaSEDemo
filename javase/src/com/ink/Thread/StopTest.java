package com.ink.Thread;

/**
 * @author ink
 * @date 2021年08月03日15:54
 */
public class StopTest implements Runnable{
//    设置标志位
    private boolean flag = true;

    @Override
    public void run() {
        int i = 0;
        while(flag) {
            System.out.println("run Thread..." + i);
            i++;
        }
    }
//    设置方法转换标志位
    public void stop(){
        this.flag = false;
    }

    public static void main(String[] args) {
        StopTest stopTest = new StopTest();
        new Thread(stopTest).start();
        for (int i = 0; i < 1000; i++) {
            System.out.println("main线程" + i);
            if(i == 900) {
//                转换标志位，停止线程
                stopTest.stop();
                System.out.println("线程停止了");
            }
        }
    }
}
