package org.nightcrwaler.keyword_match.controller;
import org.ahocorasick.trie.Emit;
import org.ahocorasick.trie.Trie;
import org.nightcrwaler.keyword_match.dto.MatchDto;
import org.nightcrwaler.keyword_match.dto.WebContent;
import org.nightcrwaler.keyword_match.service.TrieService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class AnnotateController {

    private final TrieService trieService;

    public AnnotateController(TrieService trieService) {
        this.trieService = trieService;
    }

    @PostMapping("/annotate")
    public List<MatchDto> annotate(@RequestParam Long userId, @RequestBody WebContent content) {
        Trie trie = trieService.getTrie(userId);
        Collection<Emit> emits = trie.parseText(content.getContent());
        return emits.stream()
                .map(e -> new MatchDto(e.getKeyword(), e.getStart(), e.getEnd()))
                .collect(Collectors.toList());
    }
}

