package ru.palekov.linkshortener.dto;

import lombok.*;

import javax.validation.constraints.*;
import java.time.ZonedDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CreateShortLinkRequest {

    @NotEmpty(message = "Link must not be empty")
    @Size(min = 10, max = 4096, message = "Link length must be between 10 and 4096")
    @Pattern(regexp = "https?://.+\\..+", message = "Link does not match url pattern")
    private String link;
    @Future(message = "Date must be in future")
    private ZonedDateTime endTime;
    @NotEmpty(message = "Description must not be empty")
    private String description;
    @NotNull(message = "Active flag must not be empty")
    private Boolean active;
}
