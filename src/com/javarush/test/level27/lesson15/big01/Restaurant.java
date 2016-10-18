package com.javarush.test.level27.lesson15.big01;


import com.javarush.test.level27.lesson15.big01.kitchen.Cook;
import com.javarush.test.level27.lesson15.big01.kitchen.Waitor;
import com.javarush.test.level27.lesson15.big01.statistic.StatisticEventManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Restaurant {
    private static final int ORDER_CREATING_INTERVAL = 100; //final сука забыл указать!!! Сразу бы прошло

    public static void main(String[] args) throws InterruptedException {
        Locale.setDefault(Locale.ENGLISH);
        Cook cookAmigo = new Cook("Amigo");
        Cook cook2 = new Cook("Mamigo");
        StatisticEventManager.getInstance().register(cookAmigo);
        StatisticEventManager.getInstance().register(cook2);
        List<Tablet> tablets = new ArrayList<>();
        OrderManager orderManager = new OrderManager();
        for(int i = 0;i < 5; i++){
            Tablet tablet = new Tablet(i);
            tablet.addObserver(orderManager);
            tablets.add(tablet);
        }
        Waitor waitor = new Waitor(); // Задача 19 Прошла после того, как объявление waitor опустил вниз, добавил в main InterruptedException
        cookAmigo.addObserver(waitor);
        cook2.addObserver(waitor);

        Thread t = new Thread(new RandomOrderGeneratorTask(tablets, ORDER_CREATING_INTERVAL));
        t.start();
        try
        {
            Thread.sleep(2000);

        }
        catch (InterruptedException e)
        {

        }
        t.interrupt();


        DirectorTablet directorTablet = new DirectorTablet();
        directorTablet.printAdvertisementProfit();
        directorTablet.printCookWorkloading();
        directorTablet.printActiveVideoSet();
        directorTablet.printArchivedVideoSet();
    }
}