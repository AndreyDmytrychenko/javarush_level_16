package com.lesson21.task2113.Hippodrome;

import java.util.*;

public class Hippodrome {
    public static Hippodrome game;

    private List<Horse> horses = new ArrayList<>();

    public List<Horse> getHorses() {
        return horses;
    }
    public Hippodrome(){

    }
    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public void run(){
        for (int i = 0; i < 100; i++) {
            move();
            print();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void move(){
       for (Horse horse : horses) {
           horse.move();
       }
    }
    public void print() {
        for (Horse horse : horses) {
            horse.print();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    public Horse getWinner(){
        TreeSet<Double> set = new TreeSet<>();
        for (Horse h : horses) {
            set.add(h.getDistance());
        }

        Double winDistance = set.last();
        Horse winHorse = null;
        for (Horse h : horses) {
            if (winDistance == h.getDistance()) winHorse = h;
        }
        return winHorse;
    }
    public void printWinner(){
        System.out.println("Winner is " + getWinner().getName() + "!");
    }
    public static void main(String[] args) {
        Hippodrome hip = new Hippodrome();
        Collections.addAll(hip.getHorses(), new Horse("Horse1", 3, 0), new Horse("Horse2", 3, 0), new Horse("Horse3", 3, 0));
        game = new Hippodrome(hip.getHorses());
        game.run();
        game.printWinner();

    }
}
