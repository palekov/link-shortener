package ru.palekov.linkshortener.service;

import ru.palekov.linkshortener.dto.CreateShortLinkRequest;
import ru.palekov.linkshortener.dto.CreateShortLinkResponse;
import ru.palekov.linkshortener.model.LinkInfo;

import java.util.List;
import java.util.UUID;

public interface LinkInfoService {

    CreateShortLinkResponse createLinkInfo(CreateShortLinkRequest request);

    LinkInfo getByShortLink(String shortLink);

    List<CreateShortLinkResponse> getAll();

    void deleteById(UUID id);
}



