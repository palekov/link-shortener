package ru.palekov.linkshortener.dto;

import lombok.Builder;

import javax.validation.constraints.*;
import java.time.ZonedDateTime;
import java.util.UUID;

@Builder
public record UpdateLinkInfoRequest(
        @NotNull(message = "ID must not be null")
        UUID id,
        @NotEmpty(message = "Link must not be null")
        @Size(min = 10, max = 4096, message = "Link length should be between 10 and 4096")
        @Pattern(regexp = "https?://.+\\..+", message = "Link does not match URL pattern")
        String link,
        @Future(message = "Expiration date should be in future")
        ZonedDateTime endTime,
        String description,
        Boolean active) {
}
