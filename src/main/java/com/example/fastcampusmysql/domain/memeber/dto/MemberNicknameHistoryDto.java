package com.example.fastcampusmysql.domain.memeber.dto;

import java.time.LocalDateTime;

public record MemberNicknameHistoryDto(
        Long id,
        Long memberId,
        String name,
        LocalDateTime createdAt
) {
}
