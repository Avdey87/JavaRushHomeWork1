package com.javarush.test.level27.lesson15.big01.kitchen;


import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.Tablet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Order {

    protected List<Dish> dishes;
    public Tablet tablet;
    public Order(Tablet tablet) throws IOException
    {
        this.tablet = tablet;
        this.dishes = initDishes();
    }
    public String toString()
    {
        return dishes.isEmpty() ? "" : String.format("Your order: %s of %s", dishes, tablet);
    }
    public int getTotalCookingTime()
    {
        int cookingTime = 0;
        for (Dish dish : dishes)
            cookingTime+= dish.getDuration();
        return cookingTime;
    }
    public boolean isEmpty()
    {
        return dishes.isEmpty();
    }
    public List<Dish> getDishes()
    {
        return dishes;
    }
    public Tablet getTablet()
    {
        return tablet;
    }
    protected  List<Dish> initDishes() throws IOException
    {
        return ConsoleHelper.getAllDishesForOrder();
    }
}

