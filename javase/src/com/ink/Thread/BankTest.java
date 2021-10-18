package com.ink.Thread;

/**
 * @author ink
 * @date 2021年08月04日8:57
 */
public class BankTest {
    public static void main(String[] args) {
        Account ink = new Account("ink", 100);
        Bank you = new Bank(ink, 50, "你");
        Bank girl = new Bank(ink, 100, "对象");
        you.start();
        girl.start();
    }
}

class Account extends Thread{
    String name;
    int money;

    public Account(String name, int money) {
        this.name = name;
        this.money = money;
    }
}

class Bank extends Thread{
    Account account;
    int drawingMoney;
    int nowMoney;
    public Bank(Account account,int drawingMoney, String name){
//        子类通过super调用父类的构造器时，必须放在第一位
//        调用Thread的构造器，传入name
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;

    }

    @Override
    public void run() {
//        锁的对象就是变化的量（增删改）
        synchronized (account) {
            if(account.money - drawingMoney < 0){
                System.out.println(Thread.currentThread().getName() + "存款不够，无法取钱");
                return;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            account.money -= drawingMoney;
            nowMoney += drawingMoney;
            System.out.println(account.name + "账户余额为：" + account.money);
//        this.getName() = Thread.currentThread().getName();
//        Bank继承了Thread，所以也可以使用this
            System.out.println(Thread.currentThread().getName() + "手里的余额为：" + nowMoney);
        }
    }
}
