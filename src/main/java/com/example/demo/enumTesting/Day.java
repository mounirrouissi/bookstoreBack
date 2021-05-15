package com.example.demo.enumTesting;

public enum Day {
    MONDAY("monday") ;




    private final String day;


    Day(String day) {
        this.day = day;
    }


    public  String getDay() {
        return day;
    }
}
