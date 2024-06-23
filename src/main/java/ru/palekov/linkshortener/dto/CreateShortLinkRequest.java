package ru.palekov.linkshortener.dto;

import lombok.*;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.ZonedDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CreateShortLinkRequest {

    @NotEmpty
    @Pattern(regexp = "https?://.+\\..+")
    private String link;
    @Future
    private ZonedDateTime endTime;
    @NotEmpty
    private String description;
    @NotNull
    private Boolean active;
}
