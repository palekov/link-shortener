package ru.palekov.linkshortener.service;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.palekov.linkshortener.dto.CreateShortLinkRequest;
import ru.palekov.linkshortener.dto.LinkInfoResponse;
import ru.palekov.linkshortener.exception.NotFoundException;
import ru.palekov.linkshortener.mapper.LinkInfoMapper;
import ru.palekov.linkshortener.model.LinkInfo;
import ru.palekov.linkshortener.property.LinkShortenerProperty;
import ru.palekov.linkshortener.repository.LinkInfoRepository;

import java.util.List;
import java.util.UUID;

@Service
public class LinkInfoServiceImpl implements LinkInfoService {

    @Autowired
    private LinkInfoRepository repository;

    @Autowired
    private LinkInfoMapper linkInfoMapper;

    @Autowired
    private LinkShortenerProperty linkShortenerProperty;

    public LinkInfoResponse createLinkInfo(CreateShortLinkRequest request) {
        LinkInfo linkInfo = linkInfoMapper.fromCreateRequest(request);
        linkInfo.setShortLink(RandomStringUtils.randomAlphanumeric(linkShortenerProperty.getShortLinkLength()));
        linkInfo.setOpeningCount(0L);
        repository.save(linkInfo);
        return linkInfoMapper.toResponse(linkInfo);
    }

    public LinkInfo getByShortLink(String shortLink) {
        LinkInfo linkInfo = repository.findByShortLinkAndActiveTrue(shortLink)
                .orElseThrow(()-> new NotFoundException("Information by short link " + shortLink + " is not found!"));

        repository.incrementOpeningCountByShortLink(shortLink);

        return linkInfo;
    }

    public List<LinkInfoResponse> getAll() {
        return repository.findAll().stream()
                .map(linkInfoMapper::toResponse)
                .toList();
    }

    public void deleteById(UUID id) {
        repository.deleteById(id);
    }
}
