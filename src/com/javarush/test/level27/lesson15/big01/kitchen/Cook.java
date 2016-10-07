package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by aavdeev on 06.10.2016.
 */
public class Cook extends Observable implements Observer
{
    private String name;

    public Cook(String name)
    {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg)
    {
        Order order = (Order) arg;
        ConsoleHelper.writeMessage("Start cooking - " + order + " cooking time " + order.getTotalCookingTime() + "min");
        setChanged();
        notifyObservers(order);
    }

    @Override
    public String toString()
    {
        return name;
    }
}
