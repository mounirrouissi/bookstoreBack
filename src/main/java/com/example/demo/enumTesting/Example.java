package com.example.demo.enumTesting;

public enum Example {
    INSTANCE,

    INSTANCE3{

        @Override
        public void sayHello() {
            System.out.println("hello Instance 3 here");

        }
    }
    ,INSTANCE2
    ,INSTANCE4;

    public void sayHello(){
        System.out.println("hello");
    }


    Example() {
        System.out.println("called Here");
    }
}
