package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.ad.AdvertisementManager;
import com.javarush.test.level27.lesson15.big01.ad.NoVideoAvailableException;
import com.javarush.test.level27.lesson15.big01.kitchen.Order;


import java.io.IOException;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tablet extends Observable {
    final int number;
    public static Logger logger = Logger.getLogger(Tablet.class.getName());
    public Tablet(int number) {
        this.number = number;
    }
    public void createOrder(){
        Order order=null;
        try {
            order = new Order(this);
            helpForCreating(order);
        }catch (IOException e ){
            logger.log(Level.SEVERE, "Console is unavailable.");//
        }
    }

    public void createTestOrder(){
        Order order=null;
        try {
            order = new Order(this);
            helpForCreating(order);
        }catch (IOException e ){
            logger.log(Level.SEVERE, "Console is unavailable.");//
        }
    }

    private void helpForCreating(Order order)  {
        ConsoleHelper.writeMessage(order.toString());
        try {
            new AdvertisementManager(order.getTotalCookingTime()*60).processVideos();
            if (!order.isEmpty()) {
                setChanged();
                notifyObservers(order);
            }
        }catch (NoVideoAvailableException v){
            logger.log(Level.INFO, "No video is available for the order " + order);
        }
    }




    @Override
    public String toString() {
        return "Tablet{" +
                "number=" + number +
                '}';
    }
}