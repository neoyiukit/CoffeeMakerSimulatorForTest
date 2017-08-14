package com.coffeeApp;

/**
 * Created by neo.yiu on 14/08/2017.
 * This is to describe the coffee we serve
 */
public final class Coffee {

    private final CoffeeType type;
    private final int beans;
    private final int milk;

    public Coffee(CoffeeType coffeeType, int beans, int milk) {
        this.type = coffeeType;
        this.beans = beans;
        this.milk = milk;
    }

    public CoffeeType getType() {
        return type;
    }

    public int getBeans() {
        return beans;
    }

    public int getMilk() {
        return milk;
    }

    @Override
    public String toString() {
        return "Coffee{" +
                "type=" + type +
                ", beans=" + beans +
                ", milk=" + milk +
                '}';
    }
}

