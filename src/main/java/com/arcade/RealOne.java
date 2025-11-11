package com.arcade;

public class RealOne {
    String name;
    String color;

    public double calc(double a, double b) {
        return Math.pow(a, b);
    }

    public String reverser(String a) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(a).reverse();
        return stringBuilder.toString();
    }

    public void theMethodWhoThrowsException() {
        throw new ArithmeticException();
    }






    public int sum(int a, int b) {
        return a + b;
    }

    public RealOne() {
    }

    public RealOne(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public RealOne(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }


}
