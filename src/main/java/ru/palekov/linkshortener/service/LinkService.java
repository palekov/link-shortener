package ru.palekov.linkshortener.service;

import org.apache.commons.lang3.RandomStringUtils;
import ru.palekov.linkshortener.dto.CreateShortLinkRequest;

import static ru.palekov.linkshortener.util.Constants.SHORT_LINK_LENGTH;

public class LinkService {

    public String generateShortLink(CreateShortLinkRequest request) {
        String link = request.getLink();
        return RandomStringUtils.randomAlphanumeric(SHORT_LINK_LENGTH);
    }
}
