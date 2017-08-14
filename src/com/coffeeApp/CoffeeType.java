package com.coffeeApp;

/**
 * Created by neo.yiu on 14/08/2017.
 * To describe the type of coffee we are going to serve
 */
public enum CoffeeType {
    Espresso(7, 0),
    Latte(7, 227),
    FilterCoffee(10, 0);

    private final int requiredBeans;
    private final int requiredMilk;

    CoffeeType(int requiredBeans, int requiredMilk) {
        this.requiredBeans = requiredBeans;
        this.requiredMilk = requiredMilk;
    }

    public int getRequiredBeans() {
        return requiredBeans;
    }

    public int getRequiredMilk() {
        return requiredMilk;
    }
}
