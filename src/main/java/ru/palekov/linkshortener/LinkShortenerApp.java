package ru.palekov.linkshortener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.palekov.LoggingConfigurationGradle;
import ru.palekov.LoggingConfigurationMaven;

@SpringBootApplication
public class LinkShortenerApp {
    public static void main(String[] args) {
        LoggingConfigurationMaven.testLog("test logging from maven lib is working!");
        LoggingConfigurationGradle.testLog("test logging from gradle lib is working!");
        SpringApplication.run(LinkShortenerApp.class);
    }
}
