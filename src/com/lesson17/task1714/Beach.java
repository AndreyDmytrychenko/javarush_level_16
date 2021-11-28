package com.lesson17.task1714;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Beach implements Comparable<Beach>{
    private String name;      //название
    private float distance;   //расстояние
    private int quality;    //качество

    public Beach(String name, float distance, int quality) {
        this.name = name;
        this.distance = distance;
        this.quality = quality;
    }

    public synchronized String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    public synchronized float getDistance() {
        return distance;
    }

    public synchronized void setDistance(float distance) {
        this.distance = distance;
    }

    public synchronized int getQuality() {
        return quality;
    }

    public synchronized void setQuality(int quality) {
        this.quality = quality;
    }
    public static List<Beach> beaches = new ArrayList<>();

    @Override
    public String toString() {
        return "Beach{" +
                "name='" + name + '\'' +
                ", distance=" + distance +
                ", quality=" + quality +
                '}';
    }

    public synchronized static void main(String[] args) {

        Beach beach1 = new Beach("Malibu1", 4, 6);
        Beach beach2 = new Beach("Malibu2", 7, 3);
        Beach beach3 = new Beach("Malibu3", 4, 2);
        Beach beach4 = new Beach("Malibu4", 11, 5);

        beaches.add(beach2);
        beaches.add(beach1);
        beaches.add(beach3);
        beaches.add(beach4);
        Collections.sort(beaches);
        for (Beach b : beaches) System.out.println(b.toString());
    }

    @Override
    public synchronized int compareTo(Beach o) {
        int i = 0;
        i = (this.distance/this.quality < o.distance/o.quality) ? 1 :
                (this.distance/this.quality > o.distance/o.quality) ? -1 : 0;
        return i;
    }
    /*
    *  @Override
    public synchronized int compareTo(Beach o) {
        return (int)((((o.getDistance() / this.getDistance()) - (this.getDistance() / o.getDistance()))
                + ((this.getQuality() / o.getQuality()) - (o.getQuality() / this.getQuality()))) * 100);
    }
    * */
}
