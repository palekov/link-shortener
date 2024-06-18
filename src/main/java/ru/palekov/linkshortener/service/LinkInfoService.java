package ru.palekov.linkshortener.service;

import ru.palekov.linkshortener.dto.CreateShortLinkRequest;
import ru.palekov.linkshortener.model.LinkInfo;

public interface LinkInfoService {

    LinkInfo createLinkInfo(CreateShortLinkRequest request);

    LinkInfo getByShortLink(String shortLink);
}
