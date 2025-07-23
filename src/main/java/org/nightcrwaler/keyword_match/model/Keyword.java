package org.nightcrwaler.keyword_match.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "keywords")
@IdClass(Keyword.KeywordId.class)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Keyword {

    @Id
    @Column(name = "user_id")
    private Long userId;

    @Id
    @Column(name = "keyword")
    private String keyword;


    public static class KeywordId implements Serializable {
        private Long userId;
        private String keyword;

        public KeywordId() {}

        public KeywordId(Long userId, String keyword) {
            this.userId = userId;
            this.keyword = keyword;
        }
    }
}
