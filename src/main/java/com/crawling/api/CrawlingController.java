package com.crawling.api;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RequestMapping("/crawling")
@RestController
public class CrawlingController {
    @GetMapping("/test")
    public void test(){
        String URL = "https://finance.naver.com/item/main.naver?code=005930";

        Document doc;

        try {
            doc = Jsoup.connect(URL).get();
            Elements elem = doc.select(".new_totalinfo dl>dd");
            System.out.println(elem);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
