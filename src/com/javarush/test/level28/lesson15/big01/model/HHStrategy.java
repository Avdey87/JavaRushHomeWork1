package com.javarush.test.level28.lesson15.big01.model;


import com.javarush.test.level28.lesson15.big01.vo.Vacancy;

import java.util.List;

public class HHStrategy implements Strategy
{
    private static final String URL_FORMAT = "https://hh.ru/search/vacancy?text=java&enable_snippets=true&clusters=true&area=1&page=1";
    @Override
    public List<Vacancy> getVacancies(String searchString)
    {
        return null;
    }
}
