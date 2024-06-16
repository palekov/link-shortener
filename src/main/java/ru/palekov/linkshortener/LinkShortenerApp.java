package ru.palekov.linkshortener;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.palekov.linkshortener.dto.CreateShortLinkRequest;
import ru.palekov.linkshortener.model.LinkInfo;
import ru.palekov.linkshortener.service.LinkInfoService;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@SpringBootApplication
public class LinkShortenerApp {
    public static void main(String[] args) {

        LinkInfoService linkInfoService = new LinkInfoService();

        CreateShortLinkRequest shortLinkRequest = new CreateShortLinkRequest("my link",
                ZonedDateTime.of(2030, 10, 30, 0, 0, 0, 0,
                        ZoneId.of("Europe/Minsk")),
                "my link description", true );

        LinkInfo linkInfo = linkInfoService.createLinkInfo(shortLinkRequest);
        String shortLink = linkInfo.getShortLink();
        System.out.println("Short link is: " + shortLink);
        System.out.println("getByShortLink result is:" + linkInfoService.getByShortLink(shortLink));

//        SpringApplication.run(LinkShortenerApp.class);
    }
}
