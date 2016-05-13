package com.javarush.test.level13.lesson02.task05;

/* 4 ошибки
Исправь 4 ошибки в программе, чтобы она компилировалась.
Объявление интерфейсов не изменять.
*/

public class Solution
{
    static int INDEX = 1;
    public static void main(String[] args) throws Exception
    {

        System.out.println(new Hobbie().HOBBIE.toString());
        System.out.println(new Hobbie().toString());

    }

        interface Desire
        {
        }

        interface Dream
        {
              Hobbie HOBBIE = new Hobbie();
        }

        static class Hobbie implements Dream, Desire
        {


            @Override
            public String toString()
            {
                INDEX++;
                return "" + INDEX;
            }
        }

}
