package com.example.boottest.testxjb;


import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Student extends People {
    public String name;

    public Student(String name) {
        this.name = name;
    }

    public String toString(){
        return "this:"+this.name+"super:"+super.toString();
    }

    public String ob(String test){return test;}
}
