package com.javarush.test.level26.lesson15.big01;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by aavdeev on 16.08.2016.
 */
public class CurrencyManipulator
{
    private String currencyCode;
    Map<Integer, Integer> denominations = new HashMap<>();

    public String getCurrencyCode()
    {
        return currencyCode;
    }

    public CurrencyManipulator(String currencyCode)
    {
        this.currencyCode = currencyCode;
    }
}
