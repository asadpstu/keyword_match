package org.nightcrwaler.keyword_match;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class KeywordMatchApplication {

    public static void main(String[] args) {
        SpringApplication.run(KeywordMatchApplication.class, args);
    }

}
