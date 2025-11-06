package com.arcade;

public class Shepherd {

    String name;
    Integer age;

    public Shepherd(String name) {
        this.name = name;
    }

    public Shepherd(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Shepherd{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
