package ru.palekov.linkshortener.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StopWatch;
import ru.palekov.linkshortener.dto.CreateShortLinkRequest;
import ru.palekov.linkshortener.dto.FilterLinkInfoRequest;
import ru.palekov.linkshortener.dto.LinkInfoResponse;
import ru.palekov.linkshortener.dto.UpdateLinkInfoRequest;
import ru.palekov.linkshortener.model.LinkInfo;

import java.util.List;
import java.util.UUID;

@Slf4j
public class LinkInfoServiceLoggingProxy implements LinkInfoService {

    private final LinkInfoService linkInfoService;

    private StopWatch stopWatch;

    public LinkInfoServiceLoggingProxy(LinkInfoService linkInfoService) {
        this.linkInfoService = linkInfoService;
    }

    @Override
    public LinkInfoResponse createLinkInfo(CreateShortLinkRequest request) {
        stopWatch = new StopWatch();
        stopWatch.start();
        try {
            return linkInfoService.createLinkInfo(request);
        } finally {
            stopWatch.stop();
            log.info("Method <createLinkInfo> runtime: {} ms", stopWatch.getTotalTimeMillis());
        }
    }

    @Override
    public LinkInfo getByShortLink(String shortLink) {
        stopWatch = new StopWatch();
        stopWatch.start();
        try {
            return linkInfoService.getByShortLink(shortLink);
        } finally {
            stopWatch.stop();
            log.info("Method <getByShortLink> runtime: {} ms", stopWatch.getTotalTimeMillis());
        }
    }

    @Override
    public List<LinkInfoResponse> getAll() {
        return linkInfoService.getAll();
    }

    @Override
    public void deleteById(UUID id) {
    }

    public List<LinkInfoResponse> findByFilter(FilterLinkInfoRequest filterRequest) {
        return linkInfoService.findByFilter(filterRequest);
    }

    public LinkInfoResponse updateById(UpdateLinkInfoRequest request) {
        return linkInfoService.updateById(request);
    }
}
