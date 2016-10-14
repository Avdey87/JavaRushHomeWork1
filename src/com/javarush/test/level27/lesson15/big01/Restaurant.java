package com.javarush.test.level27.lesson15.big01;


import com.javarush.test.level27.lesson15.big01.kitchen.Cook;
import com.javarush.test.level27.lesson15.big01.kitchen.Waitor;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Restaurant {
    private static int ORDER_CREATING_INTERVAL = 100;
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        List<Tablet> tablets = new ArrayList<>();
        Cook cook1 = new Cook("Burda");
        Cook cook2 = new Cook("Makarevich");
        Waitor waitor = new Waitor();
        cook1.addObserver(waitor);
        cook2.addObserver(waitor);
        for (int i=1; i<=10; i++)
        {
            tablets.add(new Tablet(i));
            if(i%2 == 0) tablets.get(i-1).addObserver(cook1);
            else tablets.get(i-1).addObserver(cook2);
        }
        RandomOrderGeneratorTask generator = new RandomOrderGeneratorTask(tablets, ORDER_CREATING_INTERVAL);
        Thread thread = new Thread(generator);
        thread.start();
        try
        {
            Thread.sleep(3000);
        }catch(InterruptedException e){}
        thread.interrupt();
        DirectorTablet director = new DirectorTablet();
        director.printAdvertisementProfit();
        director.printCookWorkloading();
        director.printActiveVideoSet();
        director.printArchivedVideoSet();
    }
}