package ru.palekov.linkshortener.service;

import ru.palekov.linkshortener.dto.CreateShortLinkRequest;
import ru.palekov.linkshortener.dto.CreateShortLinkResponse;
import ru.palekov.linkshortener.model.LinkInfo;

public interface LinkInfoService {

    CreateShortLinkResponse createLinkInfo(CreateShortLinkRequest request);

    LinkInfo getByShortLink(String shortLink);
}
