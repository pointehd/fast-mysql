package com.example.fastcampusmysql.domain.memeber.service;

import com.example.fastcampusmysql.domain.memeber.dto.RegisterMemberCommand;
import com.example.fastcampusmysql.domain.memeber.entity.Member;
import com.example.fastcampusmysql.domain.memeber.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberWriteService {
    final private MemberRepository memberRepository;
    public Member create(RegisterMemberCommand command) {
        /*
        목표 - 회원정보(이메일, 닉네임, 생년월일)를 등록한다.
            - 닉네임은 10자를 넘길 수 없다.

        memberRepostiory.save()
         * */

        Member member = Member.builder()
                .nickname(command.nickname())
                .email(command.email())
                .birthday(command.birthdate())
                .build();
        return memberRepository.save(member);
    }
}
