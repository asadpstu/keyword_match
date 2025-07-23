package org.nightcrwaler.keyword_match.controller;

import org.nightcrwaler.keyword_match.model.Keyword;
import org.nightcrwaler.keyword_match.repository.KeywordRepository;
import org.nightcrwaler.keyword_match.dto.KeywordRequest;
import org.nightcrwaler.keyword_match.service.TrieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/keywords")
public class KeywordController {

    private final KeywordRepository repo;
    private final TrieService trieService;

    public KeywordController(KeywordRepository repo, TrieService trieService) {
        this.repo = repo;
        this.trieService = trieService;
    }

    @PostMapping("/add")
    public ResponseEntity<Void> add(@RequestParam Long userId, @RequestBody KeywordRequest request) {
        repo.save(new Keyword(userId, request.keyword()));
        trieService.evictTrie(userId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> delete(@RequestParam Long userId, @RequestBody KeywordRequest request) {
        repo.deleteById(new Keyword.KeywordId(userId, request.keyword()));
        trieService.evictTrie(userId);
        return ResponseEntity.ok().build();
    }
}
