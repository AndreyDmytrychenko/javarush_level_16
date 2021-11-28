package com.lesson29.task2909.car;

public class Cabriolet extends Car{

    public Cabriolet(int numberOfPassengers) {
        super(0, numberOfPassengers);
    }

    @Override
    public int getMaxSpeed() {
        return Car.MAX_CABRIOLET_SPEED;
    }
}
