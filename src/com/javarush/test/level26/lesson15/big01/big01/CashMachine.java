package com.javarush.test.level26.lesson15.big01.big01;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by aavdeev on 03.10.2016.
 */
public class CashMachine
{
    public static final String RESOURCE_PATH = "com.javarush.test.level26.lesson15.big01.resources.";
    public static void main(String[] args)
    {
        Locale.setDefault(Locale.ENGLISH);
        ResourceBundle res = ResourceBundle.getBundle(RESOURCE_PATH + "common_en", Locale.ENGLISH);

    }
}
