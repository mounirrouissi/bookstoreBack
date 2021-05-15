package com.example.demo.polyTest;

public class Animal {
    public  static String x="animal class";
    public String y;
    public static String sayhi () {
    return x;
    }
    public String sayBy () {
    return sayhi();
    }


    public String getX() {
        return x;
    }


    public void setX(String x) {
        this.x = x;
    }


    public String getY() {
        return y;
    }


    public void setY(String y) {
        this.y = y;
    }


    public Animal() {
    }


    public Animal(String x) {
        System.out.println(x);
    }
}
