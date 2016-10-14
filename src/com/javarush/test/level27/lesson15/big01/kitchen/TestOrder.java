package com.javarush.test.level27.lesson15.big01.kitchen;


import com.javarush.test.level27.lesson15.big01.Tablet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;


public class TestOrder extends Order
{
    public TestOrder(Tablet tablet) throws IOException
    {
        super(tablet);
    }

    @Override
    protected void initDishes() throws IOException
    {
        dishes = new ArrayList<>();
        Dish[] dishMas = Dish.values();
        for(int i = 0; i < (int)(Math.random() * Dish.values().length); i++){
            int random = (int)(Math.random() * (Dish.values().length));
            dishes.add(dishMas[random]);
        }
    }
}