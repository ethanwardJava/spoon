package com.arcade;

public class Animal {

    String name;
    int age;
    Shepherd shepherd;

    public Animal(Shepherd shepherd) {
        this.shepherd = shepherd;
    }

    public Shepherd getShepherd() {
        return shepherd;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}
