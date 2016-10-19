package com.javarush.test.level28.lesson15.big01;

import com.javarush.test.level28.lesson15.big01.model.Provider;
import com.javarush.test.level28.lesson15.big01.vo.Vacancy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Controller
{
    private Provider[] providers;

    @Override
    public String toString()
    {
        return "Controller{" +
                "providers=" + Arrays.toString(providers) +
                '}';
    }

    public Controller(Provider... providers)
    {
        if (providers == null || providers.length == 0)
            throw new IllegalArgumentException();
        this.providers = providers;
    }

    public void scan() {
        ArrayList<Vacancy> vacs = new ArrayList<>();
        try{
            for (Provider provider:providers){
                for (Vacancy vacancy:provider.getJavaVacancies("SOME TEXT")){
                    vacs.add(vacancy);
                }
            }
        }catch(NullPointerException e){/*NOP*/}
        System.out.println(vacs.size());
    }
}