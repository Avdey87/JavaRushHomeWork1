package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.kitchen.Cook;
import com.javarush.test.level27.lesson15.big01.kitchen.Order;
import com.javarush.test.level27.lesson15.big01.statistic.StatisticEventManager;

import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.LinkedBlockingQueue;


public class OrderManager implements Observer{ //не синглтон
    private LinkedBlockingQueue<Order> queue = new LinkedBlockingQueue<>();

    public OrderManager() {
        Thread t = new Thread() {
            @Override
            public void run() {
                while (!Thread.currentThread().isInterrupted()) {
                    if (queue.peek() != null)
                        for (Cook cook : StatisticEventManager.getInstance().getCooks())
                            if (!cook.isBusy()) {
                                final Cook cookFinal = cook;
                                Thread thr = new Thread(new Runnable() {
                                    @Override
                                    public void run() {
                                        cookFinal.startCookingOrder(queue.poll());
                                    }
                                });
                                thr.start();
                                break;
                            }
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e)
                    {
                        return;
                    }
                }

            }
        };
        t.setDaemon(true);
        t.start();
    }

    @Override
    public void update(Observable o, Object arg) {
        Order order = (Order) arg;
        queue.add(order);
    }
}
