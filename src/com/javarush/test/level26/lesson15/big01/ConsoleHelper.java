package com.javarush.test.level26.lesson15.big01;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by aavdeev on 16.08.2016.
 */
public class ConsoleHelper
{
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static void writeMessage(String message)
    {
        System.out.println(message);

    }
static void askCurrencyCode()
{
    String test;
    JProgressBar res = null;
    writeMessage(res.getString());

}
    static void getValidTwoDigits(String currencyCode)
    {

    }


    public static String readString() throws InterruptedException
    {
        String message = "";
        try
        {
            message = reader.readLine();
        }
        catch (IOException e)
        {

        }
        return message;
    }
}
