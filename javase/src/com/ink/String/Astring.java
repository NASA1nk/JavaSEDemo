package com.ink.String;

public class Astring {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "def";
        String s3 = "abcdef";
        String s4 = s1 + "def";
        String s5 = "abc" + s2;
        String s6 = "abc" + "def";
        System.out.println(s3 == s4);
        System.out.println(s3 == s5);
        System.out.println(s3 == s6);
        System.out.println(s4 == s6);
        String s7 = s5.intern();
        System.out.println(s3 == s7);
    }

}

