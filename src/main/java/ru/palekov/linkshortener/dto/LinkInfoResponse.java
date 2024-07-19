package ru.palekov.linkshortener.dto;

import lombok.Builder;

import java.time.ZonedDateTime;
import java.util.UUID;

@Builder
public record LinkInfoResponse(
        UUID id,
        String link,
        ZonedDateTime endTime,
        String description,
        Boolean active,
        String shortLink,
        Long openingCount) {
}
