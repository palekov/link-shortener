package ru.palekov.linkshortener.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.palekov.linkshortener.dto.CreateShortLinkResponse;
import ru.palekov.linkshortener.model.LinkInfo;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface LinkInfoRepository extends JpaRepository<LinkInfo, UUID> {

    Optional<LinkInfo> findByShortLink(String shortLink);
}

