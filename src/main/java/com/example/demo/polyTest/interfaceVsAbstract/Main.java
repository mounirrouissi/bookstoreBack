package com.example.demo.polyTest.interfaceVsAbstract;

public class Main {
    public static void main(String[] args) {
        Dog dog=new Chiwawa();  //implicit casting
        Chiwawa c= (Chiwawa) dog;
        Chiwawa c3= (Chiwawa) dog;
        Chiwawa c2= (Chiwawa) dog;
        Dog c1= c;


        System.out.println( dog.hi() );
        System.out.println( ((Chiwawa) dog).ch );
        System.out.println( c.s );

//        Bird wiwiz=new WizWiz();
//        Bird boma=new Boma();
//
//        System.out.println( wiwiz.hello() );
//        System.out.println( wiwiz.sound() );
//        System.out.println( boma.hello() );
    }
}
