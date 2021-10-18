package com.ink.Enumm;

public class EnumTest {
    public static void main(String[] args) {
        Season spring = Season.SPRING;
        spring.show();
        Season summer = Season.SUMMER;
        summer.show();
    }
}
interface Info{
    void show();
}
enum Season implements Info{

    SPRING("春天","1"){
        @Override
        public void show() {
            System.out.println("这是春天");
        }
    },
    SUMMER("夏天","2"){
        @Override
        public void show() {
            System.out.println("这是夏天");
        }
    },
    AUTUMN("秋天","3"){
        @Override
        public void show() {
            System.out.println("这是秋天");
        }
    },
    WINTER("冬天","4"){
        @Override
        public void show() {
            System.out.println("这是冬天");
        }
    };

    private final String seasonName;
    private final String seasonDesc;

    private Season(String seasonName,String seasonDesc){
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    @Override
    public void show() {
        System.out.println("这是一个季节");
    }
}
