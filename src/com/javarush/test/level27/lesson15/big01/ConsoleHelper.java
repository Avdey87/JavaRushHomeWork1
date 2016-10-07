package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by aavdeev on 06.10.2016.
 */
public class ConsoleHelper
{
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static void writeMessage(String message) //Метод выводит данные на консоль
    {
        System.out.println(message);
    }
    public static String readString() throws IOException //Метод считывает данные с консоли
    {
        return reader.readLine();
    }
    public static List<Dish> getAllDishesForOrder() throws IOException //Формирование списка заказа, просит выбрать из предложенного и формирует заказ по вводу слова exit
    {
        List<Dish> dishs = new ArrayList<>();
        writeMessage("Choose dishes : " + Dish.allDishesToString());
        String s;
        while(true)
        {
            s = readString();
            if(s.equals("exit")) break;
            try
            {
                dishs.add(Dish.valueOf(s));
            }
            catch (IllegalArgumentException e)
            {
                writeMessage(s + " is not detected");
            }
        }
        return dishs;
    }
}