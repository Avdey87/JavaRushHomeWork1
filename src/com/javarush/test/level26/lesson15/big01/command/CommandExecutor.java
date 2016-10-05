package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.Operation;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by aavdeev on 04.10.2016.
 */
public class CommandExecutor
{
     private static Map<Operation, Command> map = new HashMap<>();
static {
    map.put(Operation.INFO,  new InfoCommand());
    map.put(Operation.DEPOSIT, new DepositCommand());
    map.put(Operation.EXIT, new ExitCommand());
    map.put(Operation.WITHDRAW, new WithdrawCommand());

}


    public static final void execute(Operation operation)
    {
        map.get(operation).execute();
    }
}
