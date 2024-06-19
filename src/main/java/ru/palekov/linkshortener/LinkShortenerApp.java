package ru.palekov.linkshortener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.palekov.linkshortener.service.LinkInfoService;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class LinkShortenerApp {

    @Autowired
    private LinkInfoService linkInfoService;

    @PostConstruct
    public void test() {
    }

    public static void main(String[] args) {
        SpringApplication.run(LinkShortenerApp.class);
    }
}
