package com.ink.Generic;

import org.junit.Test;

import java.util.*;

/**
 * @author ink
 * @date 2021年05月25日15:14
 */
public class GenericTest {

    @Test
    public void test(){
//       List<? extends Person> list1 = null;
//       List<? super Person> list2 = null;
//
//       List<Student> list3 = null;
//       List<Person> list4 = null;
//       List<Object> list5 = null;
//       // 可以赋值
//       list1 = list3;
//       list1 = list4;
//       // 报错
//       list1 = list5;
//
//        // 报错
//        list2 = list3;
//        可以赋值
//        list2 = list4;
//        list2 = list5;

    }
    @Test
    public void test6(){
        List<String> list1 = null;
        List<Integer> list2 = null;
        List<?> list = null;
        list = list1;
        list = list2;
    }
    public void print(List<?> list){
        Iterator<?> iterator = list.iterator();
        while(iterator.hasNext()){
            Object next = iterator.next();
            System.out.println(next);
        }
    }
    @Test
    public void test5(){
        Order<String> order = new Order<>();
        Integer[] arr = new Integer[]{1,2,3,4};
        List<Integer> list = order.copyFromArrayToList(arr);
        System.out.println(list);
        String[] arr1 = new String[]{"ink","yinke"};
        List<String> strings = order.copyFromArrayToList(arr1);
        System.out.println(strings);
    }
    @Test
    public void test4(){

        SubOrder<String> subOrder = new SubOrder<String>();
        subOrder.setOrderT("ink");
        System.out.println(subOrder.toString());
    }

    @Test
    public void test3(){
        Order<String> order = new Order<String>("A",1001,"order(A)");
        System.out.println(order.toString());
        order.setOrderT("AA:order");
        System.out.println(order.toString());
    }

    @Test
    public void test2(){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(12);
        list.add(25);
//        for中可以使用int,Integer自动拆箱
        for (int number: list
             ) {
            System.out.println(number);
        }
        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
    @Test
    public void test1(){
        HashMap<String,Integer> map = new HashMap<>();
        map.put("ink",23);
        map.put("yinke",24);
//        泛型嵌套
        Set<Map.Entry<String, Integer>> entry = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = entry.iterator();
        while(iterator.hasNext()){
            Map.Entry<String, Integer> e = iterator.next();
            String key = e.getKey();
            Integer value = e.getValue();
            System.out.println(key + ":" + value);
        }
    }
}
