package com.javarush.test.level28.lesson15.big01;

import com.javarush.test.level28.lesson15.big01.model.Provider;
import com.javarush.test.level28.lesson15.big01.vo.Vacancy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Controller
{
    private Provider[] providers;
    public Controller(Provider... providers)
    {
        this.providers = providers;
        if (this.providers.length == 0)
            throw new IllegalArgumentException();
    }
    @Override
    public String toString()
    {
        return "Controller{" + "providers=" + Arrays.toString(providers) + '}';
    }
    public void scan()
    {
        List<Vacancy> vacancyList = new ArrayList<>();
        for (Provider provider : providers)
            for (Vacancy vacancy : provider.getJavaVacancies("Москва"))
                vacancyList.add(vacancy);
        System.out.println(vacancyList.size());
    }
}