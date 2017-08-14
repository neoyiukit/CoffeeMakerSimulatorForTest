package com.coffeeApp;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by neo.yiu on 14/08/2017.
 * This is to test the functionality of Cafe class
 */
public class CafeTest {

    @Test
    public void canBrewEspresso(){ // to test if the cafe can brew Espresso

        // Given
        Cafe cafe = new Cafe();
        cafe.restockBeans(7); // beans needed to be restocked before the test

        // When
        Coffee coffee = cafe.brew(CoffeeType.Espresso);

        // Then
        // 1. To test it's an espresso, 2. there is no milk and 3. we've got enough coffee
        Assert.assertEquals(CoffeeType.Espresso, coffee.getType()); // expected value and how you got it from getType
        Assert.assertEquals(0, coffee.getMilk());
        Assert.assertEquals(7, coffee.getBeans());
    }

    @Test
    public void brewCoffeeConsumesBean(){
        // Given
        Cafe cafe = new Cafe();
        cafe.restockBeans(7); // beans needed to be restocked before the test

        // When
        Coffee coffee = cafe.brew(CoffeeType.Espresso);

        // Then
        Assert.assertEquals(0,cafe.getBeansInStock());
    }

    @Test(expected = IllegalStateException.class) // saying there will be exceptions expected
    public void latteRequiresMilk(){
        // given
        Cafe cafe = new Cafe();
        cafe.restockBeans(7);

        // When
        Coffee coffee = cafe.brew(CoffeeType.Latte);
    }
}
