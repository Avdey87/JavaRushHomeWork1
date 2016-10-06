package com.javarush.test.level26.lesson15.big01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by aavdeev on 05.10.2016.
 */
public class ConsoleHelper
{
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static void writeMessage(String message){
        System.out.println(message);
    }
    public static String readString()
    {
        String result = null;
        try { result = reader.readLine();
        }
        catch (IOException e) {}
        return result;
    }
    public static String askCurrencyCode()
    {
        String result = null;
        while (true)
        {
            writeMessage("Введите валюту");
            result = readString();
            if (result.matches("^...$"))
                break;
            else writeMessage("Данные не верны. Попробуйте еще раз.");
        }
        return result.toUpperCase();
    }
    public static String[] getValidTwoDigits(String currencyCode)
    {   String s;
        while (true)
        {
            writeMessage("Введите номиналал и количество банкнот.");
            s  = readString();
            if (s.matches("\\d+ \\d+"))
                break;
            else writeMessage("Данные не верны. Попробуйте еще раз.");
        }
        return s.split(" ");
    }
    public static Operation askOperation()
    {   Operation result = null;
        while (true){
            writeMessage("Выберите операцию. 1 - INFO, 2 - DEPOSIT, 3 - WITHDRAW, 4 - EXIT");
            try {
                result = Operation.getAllowableOperationByOrdinal(Integer.parseInt(readString()));
                break;
            } catch (Exception e) {writeMessage("Данные не верны. Попробуйте еще раз.");}}
        return result;
    }
}

