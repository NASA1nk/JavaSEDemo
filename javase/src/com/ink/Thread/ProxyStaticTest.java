package com.ink.Thread;

/**
 * @author ink
 * @date 2021年08月03日14:52
 */
public class ProxyStaticTest {
    public static void main(String[] args) {
//        真实对象，被代理
        You1 you = new You1();
//        代理对象
        Company company = new Company(you);
//        代理对象执行方法
        company.HappyMarry();
//        简写
        new Company(new You1()).HappyMarry();
//        对比线程Thread
        new Thread( ()-> System.out.println("代理实现Runnable接口的对象") ).start();
    }
}

//函数式接口
interface Marry{
    void HappyMarry();
}
//真实对象
class You1 implements Marry{
    @Override
    public void HappyMarry() {
        System.out.println("真实对象，被代理人-----结婚");
    }
}
class Company implements Marry{
//    接口对象
    private Marry target;

    public Company(Marry target) {
        this.target = target;
    }

    @Override
    public void HappyMarry() {
        before();
        this.target.HappyMarry();
        after();
    }

    private void after() {
        System.out.println("婚礼结束");
    }

    private void before() {
        System.out.println("婚礼开始");
    }
}
