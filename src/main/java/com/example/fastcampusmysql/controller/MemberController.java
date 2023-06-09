package com.example.fastcampusmysql.controller;

import com.example.fastcampusmysql.domain.memeber.dto.MemberDto;
import com.example.fastcampusmysql.domain.memeber.dto.MemberNicknameHistoryDto;
import com.example.fastcampusmysql.domain.memeber.dto.RegisterMemberCommand;
import com.example.fastcampusmysql.domain.memeber.entity.Member;
import com.example.fastcampusmysql.domain.memeber.service.MemberReadService;
import com.example.fastcampusmysql.domain.memeber.service.MemberWriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {
    final private MemberWriteService memberWriteService;
    final private MemberReadService memberReadService;

    @PostMapping("/member")
    public MemberDto register(@RequestBody RegisterMemberCommand command) {
        Member member = memberWriteService.register(command);
        return memberReadService.toDto(member);
    }

    @GetMapping("/members/{id}")
    public MemberDto getMember(@PathVariable Long id) {
        return memberReadService.getMember(id);
    }

    @PostMapping("/members/{id}/name")
    public MemberDto changeNickname(@PathVariable Long id, @RequestBody String nickname) {
        memberWriteService.changeNickname(id, nickname);
        return memberReadService.getMember(id);
    }

    @GetMapping("/members/{memberId}/nickname-histories")
    public List<MemberNicknameHistoryDto> getNicknameHistories(@PathVariable Long memberId) {
        return memberReadService.getNicknameHistories(memberId);
    }
}
