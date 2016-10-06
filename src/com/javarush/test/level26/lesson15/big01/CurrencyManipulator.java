package com.javarush.test.level26.lesson15.big01;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by aavdeev on 03.10.2016.
 */
public class CurrencyManipulator
{
    public String currencyCode;
    private Map<Integer, Integer> denominations = new HashMap<>();
    public CurrencyManipulator(String currencyCode)
    {
        this.currencyCode = currencyCode;
    }
    public String getCurrencyCode()
    {
        return currencyCode;
    }
    public void addAmount(int denomination, int count)
    {
        if(denominations.containsKey(denomination)){
            denominations.put(denomination,denominations.get(denomination)+count);
        }else{
            denominations.put(denomination,count);
        }
    }
    public int getTotalAmount()
    {   int result = 0;
        for (Map.Entry<Integer,Integer> entry: denominations.entrySet())
        {
            result +=(entry.getKey()*entry.getValue());
        }
        return result;
    }
    public boolean hasMoney()
    {
        if (denominations.isEmpty() )
            return false;
        else return true;
    }
}
