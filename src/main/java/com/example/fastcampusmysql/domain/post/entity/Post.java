package com.example.fastcampusmysql.domain.post.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@ToString
@Getter
public class Post {
    final private Long id;
    final private String content;
    final private Long memberId;
    final private LocalDate createDate;
    final private LocalDateTime createAt;


    @Builder
    public Post(Long id, String content, Long memberId, LocalDate createDate, LocalDateTime createAt) {
        this.id = id;
        this.content = Objects.requireNonNull(content);
        this.memberId = Objects.requireNonNull(memberId);
        this.createDate = createDate;
        this.createAt = createAt == null ? LocalDateTime.now() : createAt;
    }
}
