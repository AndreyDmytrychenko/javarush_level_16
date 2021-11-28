package com.lesson29.task2909.Human;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Human implements Alive{

    protected int age;
    protected String name;
    protected Size size;
    private static int nextId = 0;
    private int id;


    private BloodGroup bloodGroup;


    public void setBloodGroup(BloodGroup bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public BloodGroup getBloodGroup() {
        return bloodGroup;
    }



    public int getId() {
        return id;
    }

    private List<Human> children = new ArrayList<>();

    public List<Human> getChildren() {
        return Collections.unmodifiableList(children);
    }

    public void addChild(Human human) {
        children.add(human);
    }

    public void removeChild(Human human) {
        children.remove(human);
    }


    public Human(String name, int age) {
        this.name = name;
        this.age = age;
        this.id = nextId;
        nextId++;

    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return "Человек";
    }

    public void printData() {
        System.out.println(String.format("%s: %s",getPosition(),name));
    }

    @Override
    public void live() {

    }

    public class Size {

       public int height;
       public int weight;

    }
}


