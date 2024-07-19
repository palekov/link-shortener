package ru.palekov.linkshortener.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.palekov.linkshortener.dto.CreateShortLinkRequest;
import ru.palekov.linkshortener.dto.FilterLinkInfoRequest;
import ru.palekov.linkshortener.dto.IdRequest;
import ru.palekov.linkshortener.dto.LinkInfoResponse;
import ru.palekov.linkshortener.dto.common.CommonRequest;
import ru.palekov.linkshortener.dto.common.CommonResponse;
import ru.palekov.linkshortener.service.LinkInfoService;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/link-infos")
public class LinkInfoController {

    private final LinkInfoService linkInfoService;

    @PostMapping
    public CommonResponse<LinkInfoResponse> postCreateShortLink(
            @RequestBody @Valid CommonRequest<CreateShortLinkRequest> request) {
        log.info("Received request to create short link: {}", request);

        LinkInfoResponse linkInfoResponse = linkInfoService.createLinkInfo(request.getBody());

        return CommonResponse.<LinkInfoResponse>builder()
                .body(linkInfoResponse)
                .build();
    }

    @PostMapping("/filter")
    public CommonResponse<List<LinkInfoResponse>> filter(@RequestBody @Valid
                                                         CommonRequest<FilterLinkInfoRequest> request) {
        List<LinkInfoResponse> linkInfoResponses = linkInfoService.findByFilter(request.getBody());

        return CommonResponse.<List<LinkInfoResponse>>builder()
                .body(linkInfoResponses)
                .build();
    }

    @DeleteMapping
    public CommonResponse<?> deleteById(@RequestBody @Validated CommonRequest<IdRequest> request) {
        linkInfoService.deleteById(request.getBody().getId());

        return CommonResponse.builder().build();
    }
}
