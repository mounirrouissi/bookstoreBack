package com.example.demo.java.inter;

public interface  Animal1 {
   int c=23;
       default void getName(){
            System.out.println("default name");
       };
}
