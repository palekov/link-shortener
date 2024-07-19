package ru.palekov.linkshortener.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import ru.palekov.linkshortener.model.LinkInfo;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

public interface LinkInfoRepository extends JpaRepository<LinkInfo, UUID> {

    Optional<LinkInfo> findByShortLinkAndActiveTrue(String shortLink);

    @Query("""
            UPDATE LinkInfo li
            SET li.openingCount = li.openingCount + 1
            WHERE li.shortLink = :shortLink
            """)
    @Modifying
    @Transactional
    void incrementOpeningCountByShortLink(String shortLink);

}

