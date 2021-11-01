package com.example.boottest.enumtest;

public enum  enumtest {
    SPRING("春天"),SUMMER("夏天"),FALL("秋天"),WINTER("冬天");

    private final String name;


    enumtest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
