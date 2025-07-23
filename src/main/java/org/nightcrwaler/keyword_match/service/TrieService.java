package org.nightcrwaler.keyword_match.service;
import org.ahocorasick.trie.Trie;
import org.nightcrwaler.keyword_match.model.Keyword;
import org.nightcrwaler.keyword_match.repository.KeywordRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrieService {

    private final KeywordRepository keywordRepository;

    public TrieService(KeywordRepository keywordRepository) {
        this.keywordRepository = keywordRepository;
    }

    @Cacheable(value = "trieCache", key = "#userId")
    public Trie getTrie(Long userId) {
        List<String> keywords = keywordRepository.findByUserId(userId)
                .stream()
                .map(Keyword::getKeyword)
                .collect(Collectors.toList());

        return Trie.builder()
                .addKeywords(keywords)
                .build();
    }


    @CacheEvict(value = "trieCache", key = "#userId")
    public void evictTrie(Long userId) {
        // Cache eviction trigger; no body needed
    }
}


