package ru.palekov.linkshortener.service;

import ru.palekov.linkshortener.dto.CreateShortLinkRequest;
import ru.palekov.linkshortener.dto.FilterLinkInfoRequest;
import ru.palekov.linkshortener.dto.LinkInfoResponse;
import ru.palekov.linkshortener.dto.UpdateLinkInfoRequest;
import ru.palekov.linkshortener.model.LinkInfo;

import java.util.List;
import java.util.UUID;

public interface LinkInfoService {

    LinkInfoResponse createLinkInfo(CreateShortLinkRequest request);

    LinkInfo getByShortLink(String shortLink);

    List<LinkInfoResponse> getAll();

    void deleteById(UUID id);

    List<LinkInfoResponse> findByFilter(FilterLinkInfoRequest filterRequest);

    LinkInfoResponse updateById(UpdateLinkInfoRequest request);
}



