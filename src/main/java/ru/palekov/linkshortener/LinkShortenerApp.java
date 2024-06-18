package ru.palekov.linkshortener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.palekov.linkshortener.dto.CreateShortLinkRequest;
import ru.palekov.linkshortener.service.LinkInfoService;
import ru.palekov.linkshortener.service.LinkInfoServiceLoggingProxy;

import javax.annotation.PostConstruct;
import java.time.ZonedDateTime;

@SpringBootApplication
public class LinkShortenerApp {

    @Autowired
    private LinkInfoService linkInfoService;

    @PostConstruct
    public void test() {
        LinkInfoServiceLoggingProxy proxy = new LinkInfoServiceLoggingProxy(linkInfoService);
        CreateShortLinkRequest shortLinkRequest =
                new CreateShortLinkRequest(
                        "www.yandex.by",
                        ZonedDateTime.now().plusHours(2),
                        "Yandex link for Belarusian citizens",
                        true);
        System.out.println(proxy.getByShortLink(
                proxy.createLinkInfo(shortLinkRequest).getShortLink()));
    }

    public static void main(String[] args) {
        SpringApplication.run(LinkShortenerApp.class);
    }
}
