package com.javarush.test.level28.lesson15.big01.model;


import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class HHStrategy implements Strategy {
    private static final String URL_FORMAT = "http://hh.ua/search/vacancy?text=java+%s&page=%d";
    private static final String userAgent = "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.116 Safari/537.36 OPR/40.0.2308.81";
    private static final String referrer = "";

    @Override
    public List<Vacancy> getVacancies(String searchString) {
        List<Vacancy> vacancyList = new ArrayList<>();
        int page = 0;
        try {
            while (page < 1) {
                Document document = getDocument(searchString, page);
                Elements elements = document.select("[data-qa~=(^| )vacancy-serp__vacancy($| )]");
                if (elements.isEmpty()) break;

                for (Element element : elements) {
                    Vacancy curVacancy = new Vacancy();

                    Element title = element.select("[data-qa=vacancy-serp__vacancy-title]").first();
                    curVacancy.setTitle(title.text());
                    curVacancy.setUrl(title.attr("href"));

                    Element city = element.select("[data-qa=vacancy-serp__vacancy-address]").first();
                    curVacancy.setCity(city.text());

                    Element companyName = element.select("[data-qa=vacancy-serp__vacancy-employer]").first();
                    curVacancy.setCompanyName(companyName.text());

                    curVacancy.setSiteName("http://hh.ua");

                    Element salary = element.select("[data-qa=vacancy-serp__vacancy-compensation]").first();
                    curVacancy.setSalary(salary != null ? salary.text() : "");

                    vacancyList.add(curVacancy);
                }
                page++;
            }
        } catch (IOException ignored) {
        }
        return vacancyList;
    }

    protected Document getDocument(String searchString, int page) throws IOException {
        String url = String.format(URL_FORMAT, URLEncoder.encode(searchString, "UTF-8"), page);
        url = "http://javarush.ru/testdata/big28data.html";
        return Jsoup.connect(url).userAgent(userAgent).referrer(referrer).get();
    }
}