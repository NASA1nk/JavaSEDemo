package com.ink.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author ink
 * @date 2021年05月19日15:32
 */
public class ForTest {
    @Test
    public void test1() {
        Collection coll = new ArrayList();
        coll.add("A");
        coll.add("b");
        coll.add(new String("ink"));
        coll.add(123);
        coll.add(false);
        coll.add(new Person("ink", 20));
        for(Object obj : coll){
            System.out.println(obj);
        }
    }
}
