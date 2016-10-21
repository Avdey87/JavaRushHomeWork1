package com.javarush.test.level28.lesson15.big01;

import com.javarush.test.level28.lesson15.big01.model.*;
import com.javarush.test.level28.lesson15.big01.view.HtmlView;
import com.javarush.test.level28.lesson15.big01.view.View;


public class Aggregator {
    public static void main(String[] args) {
        HtmlView view = new HtmlView();
        Provider providerHH = new Provider(new HHStrategy());
        Provider providerLinkedIn = new Provider(new LinkedInStrategy());
        Provider providerMoikrug = new Provider(new MoikrugStrategy());
        Model model = new Model(view, new Provider[] {providerHH, providerLinkedIn,providerMoikrug});
        view.setController(new Controller(model));
        view.userCitySelectEmulationMethod();
    }
}
