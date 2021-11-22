package com;/*
 * @auther Renic.
 * @version 1.0
 */

abstract public class Cat {
    protected String name;
    protected int age;
    protected String sex;
    protected double price;

    public Cat(String name, int age, String sex, double price) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }

    public double getPrice() {
        return price;
    }

    @Override
    abstract public String toString();
}
