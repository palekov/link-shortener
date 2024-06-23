package ru.palekov.linkshortener.mapper;

import org.mapstruct.Mapper;
import ru.palekov.linkshortener.dto.CreateShortLinkRequest;
import ru.palekov.linkshortener.dto.CreateShortLinkResponse;
import ru.palekov.linkshortener.model.LinkInfo;

@Mapper(componentModel = "spring")
public interface LinkInfoMapper {
    LinkInfo fromCreateRequest(CreateShortLinkRequest request);

    CreateShortLinkResponse toResponse(LinkInfo linkInfo);
}
