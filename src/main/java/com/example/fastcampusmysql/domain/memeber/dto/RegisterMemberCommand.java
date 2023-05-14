package com.example.fastcampusmysql.domain.memeber.dto;

import java.time.LocalDate;

public record RegisterMemberCommand(
        String email,
        String nickname,
        LocalDate birthdate
) {
}
