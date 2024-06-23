package ru.palekov.linkshortener.service;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.palekov.linkshortener.dto.CreateShortLinkRequest;
import ru.palekov.linkshortener.dto.CreateShortLinkResponse;
import ru.palekov.linkshortener.exception.NotFoundException;
import ru.palekov.linkshortener.mapper.LinkInfoMapper;
import ru.palekov.linkshortener.model.LinkInfo;
import ru.palekov.linkshortener.property.LinkShortenerProperty;
import ru.palekov.linkshortener.repository.LinkInfoRepository;

@Service
public class LinkInfoServiceImpl implements LinkInfoService {

    @Autowired
    private LinkInfoRepository repository;

    @Autowired
    private LinkInfoMapper linkInfoMapper;

    @Autowired
    private LinkShortenerProperty linkShortenerProperty;

    public CreateShortLinkResponse createLinkInfo(CreateShortLinkRequest request) {
        LinkInfo linkInfo = linkInfoMapper.fromCreateRequest(request);
        linkInfo.setShortLink(RandomStringUtils.randomAlphanumeric(linkShortenerProperty.getShortLinkLength()));
        linkInfo.setOpeningCount(0L);
        repository.saveShortLink(linkInfo);
        return linkInfoMapper.toResponse(linkInfo);
    }

    public LinkInfo getByShortLink(String shortLink) {
        return repository.findByShortLink(shortLink)
                .orElseThrow(()-> new NotFoundException("Information by short link " + shortLink + " is not found!"));
    }
}
