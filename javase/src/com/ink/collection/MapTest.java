package com.ink.collection;

import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author ink
 * @date 2021年05月24日20:38
 */
public class MapTest {
    @Test
    public void test1(){

        Map map = new HashMap();
        map.put("A",87);
        map.put("b",898);
        map.put(45,23);
        System.out.println(map);
//        Map map1 = new HashMap();
//        map1.put("GG",87);
//        map1.put("23",898);
//        map1.put(45,23);
//        map.putAll(map1);
//        System.out.println(map);
//        Object value = map.remove("A");
//        System.out.println(map);
//        map1.clear();
//        System.out.println(map1.size());
//        System.out.println(map.get(45));
//        System.out.println(map.get("45"));
//        System.out.println(map.containsKey(45));
//        System.out.println(map.containsKey("45"));
//        System.out.println(map.size());
//        System.out.println(map.keySet());
//        System.out.println(map.values());
        Set set = map.entrySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            Object obj = iterator.next();
//            内部静态接口Entry
            Map.Entry entry = (Map.Entry)obj;
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

    }
}
