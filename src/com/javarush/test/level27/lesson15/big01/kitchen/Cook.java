package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.statistic.StatisticManager;
import com.javarush.test.level27.lesson15.big01.statistic.event.CookedOrderEventDataRow;


import java.util.Observable;
import java.util.Observer;

public class Cook extends Observable implements Observer
{
    public String name;
    @Override
    public String toString()
    {
        return name;
    }
    public Cook(String name)
    {
        this.name = name;
    }
    @Override
    public void update(Observable o, Object arg)
    {
        Order order= (Order) arg;
        ConsoleHelper.writeMessage(String.format("Start cooking - %s, cooking time %dmin",arg, order.getTotalCookingTime()));
        StatisticManager.getInstance().register(new CookedOrderEventDataRow(order.tablet.toString(), name, order.getTotalCookingTime() * 60, order.getDishes()));
        setChanged();
        notifyObservers(arg);
    }
}

