package com.ink.Lambda;

/**
 * @author ink
 * @date 2021年08月02日21:46
 */
public class TestLambda {
//    静态内部类
//    成员内部类+static
    static class yinke2 implements Ink{
        @Override
        public void lambda(int a) {
            System.out.println("lambda表达式->" + a);
        }
    }
    public static void main(String[] args) {
//        局部内部类
//        方法中声明
        class yinke3 implements Ink{
            @Override
            public void lambda(int a) {
                System.out.println("lambda表达式->" + a);
            }
        }
        Ink ink1 = new yinke1();
        ink1.lambda(1);
        Ink ink2 = new yinke2();
        ink2.lambda(2);
        Ink ink3 = new yinke3();
        ink3.lambda(3);

//        匿名内部类
//        没有构造器，必须借助接口或者父类的构造器
        new Ink(){
            @Override
            public void lambda(int a) {
                System.out.println("lambda表达式->" + a);
            }
        }.lambda(4);

//        lambda简化-1
//        简化构造器和方法名
        Ink ink5 = (int a) -> {
            System.out.println("lambda表达式->" + a);
        };
        ink5.lambda(5);
//        lambda简化-2
//        简化参数类型
        Ink ink6 = (a) -> {
            System.out.println("lambda表达式->" + a);
        };
        ink6.lambda(6);

//        lambda简化-3
//        简化括号()
        Ink ink7 = a -> {
            System.out.println("lambda表达式->" + a);
        };
        ink7.lambda(7);

//        lambda简化-4
//        简化花括号{}
        Ink ink8 = a -> System.out.println("lambda表达式->" + a);
        ink8.lambda(7);

    }
}

//函数式接口
interface Ink{
//    只有一个抽象方法
    void lambda(int a);
}

//实现类
class yinke1 implements Ink{
    @Override
    public void lambda(int a) {
        System.out.println("lambda表达式->" + a);
    }
}
