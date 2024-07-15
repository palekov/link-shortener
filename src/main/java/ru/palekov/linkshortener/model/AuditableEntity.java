package ru.palekov.linkshortener.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;
import java.time.ZonedDateTime;

@Getter
@Setter
@MappedSuperclass
public class AuditableEntity {

    private ZonedDateTime createTime;
    private ZonedDateTime updateTime;
}
