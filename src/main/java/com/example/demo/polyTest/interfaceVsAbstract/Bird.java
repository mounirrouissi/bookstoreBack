package com.example.demo.polyTest.interfaceVsAbstract;

public interface Bird {
String sound();
default String hello(){
    return "Hello";
}
}
