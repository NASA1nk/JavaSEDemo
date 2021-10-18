package com.ink.Enumm;

import javax.swing.*;

public class SeasonTest {
    public static void main(String[] args) {
        Season spring = Season.SPRING;
        System.out.println(spring);
    }
}
class Season1{
    private final String seasonName;
    private final String seasonDesc;
    private Season1(String seasonName,String seasonDesc){
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }
    public static final Season1 SPRING = new Season1("春天","1");
    public static final Season1 SUMMER = new Season1("夏天","2");
    public static final Season1 AUTUMN = new Season1("秋天","3");
    public static final Season1 WINTER = new Season1("冬天","4");

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    @Override
    public String toString() {
        return "Season1{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }
}

