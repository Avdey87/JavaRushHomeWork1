package com.javarush.test.level26.lesson15.big01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by aavdeev on 05.10.2016.
 */
public class ConsoleHelper
{
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    public static void  writeMessage(String message){
        System.out.println(message);
    }
    public static String readString()
    {
        String s = "";
        try {s = bufferedReader.readLine();}
        catch (IOException e) {}
        return s;
    }
    public static String askCurrencyCode(){
        String s="";
        writeMessage("Enter the currency code(3 symbols): ");
        s=readString();
        while (s.length()!=3){
            writeMessage("You've entered wrong code. Try again:");
            s = readString();
        }
        s.toUpperCase();
        return s;
    }
    public static String[] getValidTwoDigits(String currencyCode){
        String[] array;
        int nom;
        int kol;
        writeMessage("Input denomination and count, please:");
        while (true)
        {
            String s = readString();
            array = s.split(" ");
            try
            {
                nom = Integer.parseInt(array[0]);
                kol = Integer.parseInt(array[1]);
                if (nom <= 0 || kol <= 0 || array.length > 2)
                {
                    writeMessage("Incorrect input! Retry input, please:");
                    continue;
                }
                else break;
            }
            catch (Exception e){}
            writeMessage("Incorrect input! Retry input, please:");
        }
        return array;
    }
}

