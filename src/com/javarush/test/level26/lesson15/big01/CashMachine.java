package com.javarush.test.level26.lesson15.big01;

import java.util.Locale;



/**
 * Created by aavdeev on 03.10.2016.
 */
public class CashMachine
{

    public static void main(String[] args)
    {  Locale.setDefault(Locale.ENGLISH);
        String code = ConsoleHelper.askCurrencyCode();
        String[] nominalCount = ConsoleHelper.getValidTwoDigits(code);
        CurrencyManipulator manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(code);
        manipulator.addAmount(Integer.parseInt(nominalCount[0]), Integer.parseInt(nominalCount[1]));
    }


}
