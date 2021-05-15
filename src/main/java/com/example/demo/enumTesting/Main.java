package com.example.demo.enumTesting;

public class Main {
    public static void main(String[] args) {
        for (Day value : Day.values()) {
            System.out.println( value.getDay());
            if("MONDAY" == Day.MONDAY.name())
            {
                System.out.println("MONDAY  ");
            }

        }
        Example.INSTANCE.sayHello();



}}
