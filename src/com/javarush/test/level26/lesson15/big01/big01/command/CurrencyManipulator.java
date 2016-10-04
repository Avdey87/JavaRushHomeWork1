package com.javarush.test.level26.lesson15.big01.big01.command;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by aavdeev on 03.10.2016.
 */
public class CurrencyManipulator
{
    public CurrencyManipulator(String currencyCode)
    {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyCode()

    {
        return currencyCode;
    }

    private String currencyCode;

    Map<Integer, Integer> denominations = new HashMap<>();

    public void addAmount(int denomination, int count)
    {
        if(denominations.containsKey(denomination))
            denominations.put(denomination, denominations.get(denomination) + count);
        else
            denominations.put(denomination,count);

    }

    public int getTotalAmount(){
        int result = 0;
        for(Map.Entry<Integer,Integer> pair : denominations.entrySet())
            result = result + (pair.getKey() * pair.getValue());

        return result;
    }
}
