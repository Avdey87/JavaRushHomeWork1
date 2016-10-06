package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;

/**
 * Created by aavdeev on 04.10.2016.
 */
class DepositCommand implements Command
{
    @Override
    public void execute()
    {
        String code = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator cm = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(code);
        String[] str = ConsoleHelper.getValidTwoDigits(code);
        cm.addAmount(Integer.parseInt(str[0]), Integer.parseInt(str[1]));
    }
}
