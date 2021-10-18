package com.ink.Compare;

import java.util.Arrays;
import java.util.Comparator;

public class Compare {
    public static void main(String[] args) {
        String[] arr = new String[]{"A","B","C","D","E"};
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return -o1.compareTo(o2);
            }
        });
        Arrays.sort(arr, (o1, o2)-> -o1.compareTo(o2));
        System.out.println(Arrays.toString(arr));
    }
}
    // Goods[] arr = new Goods[6];
    //     arr[0] = new Goods("12",62);
    //             arr[1] = new Goods("232",24);
    //             arr[2] = new Goods("1100",24);
    //             arr[3] = new Goods("230923",37);
    //             arr[4] = new Goods("12983138930",37);
    //             arr[5] = new Goods("92",37);
