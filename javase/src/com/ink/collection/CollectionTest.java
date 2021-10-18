package com.ink.collection;

import org.junit.Test;

import java.util.*;

/**
 * @author ink
 * @date 2021年05月18日20:27
 */
public class CollectionTest {

    @Test
    public void test1(){
        Collection coll = new ArrayList();
        coll.add("A");
        coll.add("b");
        // 自动装箱
        coll.add(123);
        coll.add(new Date());
        // 4
        System.out.println(coll.size());
        Collection coll1 = new ArrayList();
        coll1.add("C");
        coll1.add("D");
        coll1.add("456");
        coll.addAll(coll1);
        // [A, b, 123, Tue May 18 22:38:09 CST 2021, C, D, 456]
        System.out.println(coll);
        // false
        System.out.println(coll.isEmpty());
        coll.clear();
        // true
        System.out.println(coll.isEmpty());
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
        boolean contains = coll.contains(123);
        // true
        System.out.println(contains);
        // contains判断的是内容,true
        System.out.println(coll.contains(new String("ink")));
        // 调用equals方法
        // 当Person类没有重写equals方法时默认调用Object类的equals方法，就是==，为false
        // 重写equals方法时后为true
        System.out.println(coll.contains(new Person("ink",20)));
        Collection coll1 = Arrays.asList("A","b");
        // true
        System.out.println(coll.containsAll(coll1));
        Collection coll2 = Arrays.asList("A","c");
        // false
        System.out.println(coll.containsAll(coll2));
    }
    @Test
    public void test3(){
        Collection coll = new ArrayList();
        coll.add("A");
        coll.add("b");
        coll.add(new String("ink"));
        coll.add(123);
        coll.add(false);
        coll.add(new Person("ink",20));
        Collection coll1 = Arrays.asList("A","b");
        // [A, b, ink, 123, false, Person{name='ink', age=20}]
        System.out.println(coll);
        coll.remove(new Person("ink",20));
        // A, b, ink, 123, false]
        System.out.println(coll);
        coll.removeAll(coll1);
        // [ink, 123, false]
        System.out.println(coll);
    }
    @Test
    public void test4(){
        Collection coll = new ArrayList();
        coll.add("A");
        coll.add("b");
        coll.add(123);
        coll.add(false);
        Collection coll1 = new ArrayList();
        coll1.add("A");
        coll1.add("b");
        coll1.add(123);
        coll1.add(false);
        // true
        System.out.println(coll.equals(coll1));
        Collection coll2 = new ArrayList();
        coll2.add("b");
        coll2.add("A");
        coll2.add(123);
        coll2.add(false);
        // false
        System.out.println(coll.equals(coll2));
        Collection coll3 = Arrays.asList("A","b",123,false);
        System.out.println(coll.equals(coll3));
    }
    @Test
    public void test5(){
        Collection coll = new ArrayList();
        coll.add("A");
        coll.add("b");
        coll.add(123);
        coll.add(false);
        coll.add(new Person("ink",20));
        Object[] array = coll.toArray();
        // A b 123 false Person{name='ink', age=20}
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
        List<String> list = Arrays.asList(new String[]{"ink", "java"});
        // [ink, java]
        System.out.println(list);
        List<int[]> list1 = Arrays.asList(new int[]{123, 456});
        // [[I@56cbfb61],int[]会被认为整体是一个元素
        System.out.println(list1);
        List<Integer> list2 = Arrays.asList(new Integer[]{123, 456});
        // [123, 456],包装类可以被识别为两个元素
        System.out.println(list2);
    }
}
