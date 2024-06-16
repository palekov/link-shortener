package ru.palekov.linkshortener.service;

import org.apache.commons.lang3.RandomStringUtils;
import ru.palekov.linkshortener.dto.CreateShortLinkRequest;
import ru.palekov.linkshortener.exception.NotFoundException;
import ru.palekov.linkshortener.model.LinkInfo;
import ru.palekov.linkshortener.repository.LinkInfoRepository;
import ru.palekov.linkshortener.repository.impl.LinkInfoRepositoryImpl;

import static ru.palekov.linkshortener.util.Constants.SHORT_LINK_LENGTH;

public class LinkInfoService {

    private LinkInfoRepository repository = new LinkInfoRepositoryImpl();

    public LinkInfo createLinkInfo(CreateShortLinkRequest request) {
        LinkInfo linkInfo = new LinkInfo();
        linkInfo.setLink(request.getLink());
        linkInfo.setEndTime(request.getEndTime());
        linkInfo.setDescription(request.getDescription());
        linkInfo.setActive(request.getActive());
        linkInfo.setShortLink(RandomStringUtils.randomAlphanumeric(SHORT_LINK_LENGTH));
        return repository.saveShortLink(linkInfo);
    }

    public LinkInfo getByShortLink(String shortLink) {
        return repository.findByShortLink(shortLink)
                .orElseThrow(()-> new NotFoundException("Information by short link " + shortLink + " is not found!"));
    }
}
