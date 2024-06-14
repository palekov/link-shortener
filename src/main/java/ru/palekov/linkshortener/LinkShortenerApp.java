package ru.palekov.linkshortener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.palekov.linkshortener.dto.CreateShortLinkRequest;
import ru.palekov.linkshortener.service.LinkService;

@SpringBootApplication
public class LinkShortenerApp {
    public static void main(String[] args) {
        LinkService linkService = new LinkService();
        System.out.println(linkService.generateShortLink(new CreateShortLinkRequest()));
        SpringApplication.run(LinkShortenerApp.class);
    }
}
