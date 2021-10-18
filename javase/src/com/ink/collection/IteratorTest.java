package com.ink.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author ink
 * @date 2021年05月18日23:29
 */
public class IteratorTest {
    @Test
    public void test1(){
        Collection coll = new ArrayList();
        coll.add("A");
        coll.add("b");
        coll.add(new String("ink"));
        coll.add(123);
        coll.add(false);
        coll.add(new Person("ink",20));
        // 依次遍历集合的6个元素
        Iterator iterator = coll.iterator();
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        报异常java.util.NoSuchElementException
//        System.out.println(iterator.next());
//        for (int i = 0; i < coll.size(); i++) {
//            System.out.println(iterator.next());
//        }
        // 方法三,推荐
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
    @Test
    public void test2(){
        Collection coll = new ArrayList();
        coll.add("A");
        coll.add("b");
        coll.add(new String("ink"));
        coll.add(123);
        coll.add(false);
        coll.add(new Person("ink",20));
        // 错误:死循环
        while(coll.iterator().hasNext()){
           System.out.println(coll.iterator().next());
        }
    }
    @Test
    public void test(){
        Collection coll = new ArrayList();
        coll.add("A");
        coll.add("b");
        coll.add(new String("ink"));
        coll.add(123);
        coll.add(false);
        Iterator iterator = coll.iterator();
        while(iterator.hasNext()){
            Object obj = iterator.next();
            if("ink".equals(obj)){
                // 迭代器对象的方法
                iterator.remove();
                System.out.println("remove ink");
            }
        }
        Iterator iterator1 = coll.iterator();
        while(iterator1.hasNext()){
            System.out.println(iterator1.next());
        }

    }
}
