package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.ad.AdvertisementManager;
import com.javarush.test.level27.lesson15.big01.ad.NoVideoAvailableException;
import com.javarush.test.level27.lesson15.big01.kitchen.Order;
import com.javarush.test.level27.lesson15.big01.kitchen.TestOrder;


import java.io.IOException;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tablet extends Observable {
    private final int number;
    public static Logger logger = Logger.getLogger(Tablet.class.getName());
    public Tablet(int number)
    {
        this.number = number;
    }
    public void createOrder()
    {
        Order order = null;
        try
        {
            order = new Order(this);
            create(order);
        }
        catch (NoVideoAvailableException e)
        {
            logger.log(Level.INFO, "No video is available for the order " + order);
        }
        catch(IOException e)
        {
            logger.log(Level.SEVERE, "Console is unavailable.");
        }
    }
    public void createTestOrder()
    {
        TestOrder order = null;
        try
        {
            order = new TestOrder(this);
            create(order);
        }
        catch (NoVideoAvailableException e)
        {
            logger.log(Level.INFO, "No video is available for the order " + order);
        }
        catch(IOException e)
        {
            logger.log(Level.SEVERE, "Console is unavailable.");
        }
    }
    private void create(Order order)
    {
        String orderText = order.toString();
        ConsoleHelper.writeMessage(orderText);
        if (!order.isEmpty())
        {
            setChanged();
            notifyObservers(order);
            AdvertisementManager manager = new AdvertisementManager(order.getTotalCookingTime() * 60);
            manager.processVideos();
        }
    }
    public String toString()
    {
        return "Tablet{number=" + number + "}";
    }
    public int getNumber()
    {
        return number;
    }
}