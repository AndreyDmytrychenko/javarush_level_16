package com.lesson29.task2909.car;

import java.util.Date;

public abstract class Car {

    static public final int TRUCK = 0;
    static public final int SEDAN = 1;
    static public final int CABRIOLET = 2;

    static public final int MAX_TRUCK_SPEED = 80;
    static public final int MAX_SEDAN_SPEED = 120;
    static public final int MAX_CABRIOLET_SPEED = 90;

    double fuel;

    public double summerFuelConsumption;
    public double winterFuelConsumption;
    public double winterWarmingUp;

    private int type;

    private boolean driverAvailable;
    private int numberOfPassengers;

    protected Car(int type, int numberOfPassengers) {

        this.numberOfPassengers = numberOfPassengers;
        this.type = type;
    }



    public void fill(double numberOfLiters) throws Exception {
        if (numberOfLiters <= 0) {
            throw new Exception();
        } else {
        fuel += numberOfLiters;
        }
    }

    public boolean isSummer(Date date, Date SummerStart, Date SummerEnd){
           return date.before(SummerEnd) && date.after(SummerStart);
    }

    public double getWinterConsumption(int length) {
        return length * winterFuelConsumption + winterWarmingUp;
    }

    public double getSummerConsumption(int length) {
        return length * summerFuelConsumption;
    }

    public double getTripConsumption(Date date, int length, Date SummerStart, Date SummerEnd) {
        double consumption;
        if (isSummer(date, SummerStart, SummerEnd)) {
            consumption = getSummerConsumption(length);

        } else {
            consumption = getWinterConsumption(length);
        }
        return consumption;
    }

    public int getNumberOfPassengersCanBeTransferred() {
        if (!canPassengersBeTransferred())
        return 0;
        return numberOfPassengers;
    }

    public boolean isDriverAvailable() {
        return driverAvailable;
    }

    private boolean canPassengersBeTransferred() {
        return isDriverAvailable() && fuel > 0;
    }

    public void setDriverAvailable(boolean driverAvailable) {
        this.driverAvailable = driverAvailable;
    }

    public void startMoving() {
        if (numberOfPassengers > 0) {
            fastenPassengersBelts();
        } else fastenDriverBelt();
    }

    public void fastenPassengersBelts() {
        fastenDriverBelt();
    }

    public void fastenDriverBelt() {
    }

    public abstract int getMaxSpeed();

    public static Car create(int type, int numberOfPassengers) {

        switch (type) {
            case Car.TRUCK:
                return new Truck(numberOfPassengers);
            case Car.SEDAN:
                return new Sedan(numberOfPassengers);
            case Car.CABRIOLET:
                return new Cabriolet(numberOfPassengers);
        }

       return null;
        }
    }



