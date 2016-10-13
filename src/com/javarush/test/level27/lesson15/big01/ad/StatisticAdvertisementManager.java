package com.javarush.test.level27.lesson15.big01.ad;


import java.util.ArrayList;
import java.util.List;

public class StatisticAdvertisementManager
{
    private AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private static StatisticAdvertisementManager ourInstance = new StatisticAdvertisementManager();


    public static StatisticAdvertisementManager getInstance(){
        return ourInstance;
    }
    private StatisticAdvertisementManager(){}
    public List<Advertisement> getActiveVideoSet(){
        List<Advertisement> result = new ArrayList<>();
        List<Advertisement> advertisements= storage.list();
        for (Advertisement advertisement : advertisements){
            if (advertisement.getHits() > 0)
                result.add(advertisement);
        }
        return result;
    }
    public List<Advertisement> getArchivedVideoSet(){
        List<Advertisement> result = new ArrayList<>();
        List<Advertisement> advertisements= storage.list();
        for (Advertisement advertisement : advertisements){
            if (advertisement.getHits() == 0)
                result.add(advertisement);
        }
        return result;
    }
}
