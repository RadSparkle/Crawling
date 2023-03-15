package com.crawling.api;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RequestMapping("/crawling")
@RestController
@Component
public class CrawlingController {

    @Scheduled(fixedDelay=10000)
    @GetMapping("/test")
    public void test() throws IOException {
        String URL = "https://finance.naver.com/item/main.naver?code=005930";
        Document doc;

        doc = Jsoup.connect(URL).get();
        Elements elem = doc.select(".new_totalinfo dl>dd");

        String price = elem.get(3).text().split(" ")[1];
        System.out.println(price);
    }
}
