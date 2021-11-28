package com.lesson25.task2513.Program;

public class Program {

    public void fair(Object sender) {
        System.out.println("message");
    }

    public static void main(String[] args) {
        String message = "Fire";
        Switcher sw = new Switcher();
        Lamp lamp = new Lamp();
        Radio radio = new Radio();

        sw.addElectricityListener(lamp);
        sw.addElectricityListener(radio);

        sw.addElectricityListener(System.out::println);




        sw.addElectricityListener( sender -> System.out.println(message) );

        sw.addElectricityListener( new Program()::fair );

        sw.switchOn();


    }
}
