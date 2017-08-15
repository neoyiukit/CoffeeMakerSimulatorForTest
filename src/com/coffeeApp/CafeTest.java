package com.coffeeApp;

import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by neo.yiu on 14/08/2017.
 * This is to test the functionality of Cafe class
 */
public class CafeTest {

    public static final int ESPRESSO_BEANS = CoffeeType.Espresso.getRequiredBeans();
    public static final int NO_MILK = 0;
    public static final int NO_BEANS = 0;
    public static final int REQUIRED_MILK = CoffeeType.Latte.getRequiredMilk();

    private Cafe cafe;

    @Before
    public void before(){
        cafe = new Cafe();
    }

    @Test
    public void canBrewEspresso(){ // to test if the cafe can brew Espresso
        // Given
        WithBeans();

        // When
        Coffee coffee = cafe.brew(CoffeeType.Espresso);

        // Then
        // 1. To test it's an espresso, 2. there is no milk and 3. we've got enough coffee
        Assert.assertEquals("Wrong coffee type", CoffeeType.Espresso, coffee.getType()); // expected value and how you got it from getType
        Assert.assertEquals("Wrong milk unit", NO_MILK, coffee.getMilk());
        Assert.assertEquals("Wrong coffeeBeans unit", ESPRESSO_BEANS, coffee.getBeans());
    }

    @Test
    public void canBrewLatte(){
        // Given
        WithBeans();
        cafe.restockMilk(REQUIRED_MILK);

        // When
        Coffee coffee = cafe.brew(CoffeeType.Latte);

        // Then
        Assert.assertEquals("Wrong coffee type", CoffeeType.Latte, coffee.getType()); // expected value and how you got it from getType
    }

    @Test
    public void brewCoffeeConsumesBean(){
        // Given
        WithBeans();

        // When
        Coffee coffee = cafe.brew(CoffeeType.Espresso);

        // Then
        Assert.assertEquals("There is still bean left", NO_BEANS, cafe.getBeansInStock());
    }

    @Test(expected = IllegalStateException.class) // saying there will be exceptions expected
    public void latteRequiresMilk(){
        // given
        WithBeans();

        // When
        Coffee coffee = cafe.brew(CoffeeType.Latte);

        Assert.assertEquals("Wrong coffee type", CoffeeType.Latte, coffee.getType()); // expected value and how you got it from getType
    }

    private void WithBeans() {
        cafe.restockBeans(ESPRESSO_BEANS); // beans needed to be restocked before the test
    }
}
