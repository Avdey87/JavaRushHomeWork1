package com.javarush.test.level15.lesson12.bonus02;

/**
 * Created by aavdeev on 15.04.2016.
 */
abstract class DrinkMaker {
    abstract void getRightCup();
    abstract void putIngredient();
    abstract void pour();

    void makeDrink() {
        getRightCup();
        putIngredient();
        pour();
    }
}