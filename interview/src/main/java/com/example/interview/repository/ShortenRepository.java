package com.example.interview.repository;

import com.example.interview.model.ShortenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShortenRepository extends JpaRepository<ShortenEntity, Long> {

    ShortenEntity findShortenEntityByShortUrl(String url);

    long count();
}
