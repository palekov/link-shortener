package ru.palekov.linkshortener.repository;

import ru.palekov.linkshortener.model.LinkInfo;

import java.util.Optional;

public interface LinkInfoRepository {

    Optional<LinkInfo> findByShortLink(String shortLink);

    LinkInfo saveShortLink(LinkInfo linkInfo);
}

