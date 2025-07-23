package org.nightcrwaler.keyword_match.repository;


import org.nightcrwaler.keyword_match.model.Keyword;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface KeywordRepository extends JpaRepository<Keyword, Keyword.KeywordId> {
    List<Keyword> findByUserId(Long userId);
}

