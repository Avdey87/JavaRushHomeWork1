package com.javarush.test.level26.lesson15.big01;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by aavdeev on 03.10.2016.
 */
public final class CurrencyManipulatorFactory
{
    private static Map<String, CurrencyManipulator> map = new HashMap<>();
    private CurrencyManipulatorFactory()
    {
    }
    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode)
    {   CurrencyManipulator result;
        if (map.containsKey(currencyCode))
            result = map.get(currencyCode);
        else
        {
            result = new CurrencyManipulator(currencyCode);
            map.put(currencyCode, result);
        }
        return result;
    }
    public static Collection<CurrencyManipulator> getAllCurrencyManipulators()
    {
        return map.values();
    }



}
