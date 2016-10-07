package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.Tablet;

import java.io.IOException;
import java.util.List;

/**
 * Created by aavdeev on 06.10.2016.
 */
public class Order
{
    List<Dish> dishes;
    Tablet tablet;
    public Order(Tablet tablet) throws IOException
    {
        this.tablet = tablet;
        dishes = ConsoleHelper.getAllDishesForOrder();
    }
    public int getTotalCookingTime() // Подсчитывает общее время готовки заказа
    {
        int summa = 0;
        for(int i = 0; i < dishes.size(); i++)
        {
            summa = summa + dishes.get(i).getDuration();
        }
        return summa;
    }
    public boolean isEmpty() //Проверяет пуст ли лист заказа
    {
        return dishes.isEmpty();
    }
    @Override
    public String toString()
    {
        if(dishes.isEmpty()) return "";
        return "Your order: " + dishes + " of " +  tablet.toString();
    }
}