package com.example.fastcampusmysql.controller;

import com.example.fastcampusmysql.domain.memeber.dto.RegisterMemberCommand;
import com.example.fastcampusmysql.domain.memeber.entity.Member;
import com.example.fastcampusmysql.domain.memeber.service.MemberWriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {
    final private MemberWriteService memberWriteService;

    @PostMapping("/member")
    public Member register(@RequestBody RegisterMemberCommand command) {
        return memberWriteService.create(command);
    }
}
