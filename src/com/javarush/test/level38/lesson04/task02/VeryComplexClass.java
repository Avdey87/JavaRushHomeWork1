package com.javarush.test.level38.lesson04.task02;

/* Непроверяемые исключения (unchecked exception)
Напиши реализацию метода methodThrowsClassCastException(). Он должен
всегда кидать непроверяемое исключение ClassCastException.

Напиши реализацию метода methodThrowsNullPointerException(). Он должен
всегда кидать непроверяемое исключение NullPointerException.

Кинуть исключение (throw) явно нельзя.
*/

import java.util.Objects;

public class VeryComplexClass {
    public void methodThrowsClassCastException() {
        Object obj = new String();
        Integer integer = (Integer) obj;
        //напишите тут ваш код
    }

    public void methodThrowsNullPointerException() {
        Object unknowObject = null;
        if (unknowObject.equals("know"))
        {
            System.out.println("OK");
        }
        //напишите тут ваш код
    }
}
