package com.example.fastcampusmysql.domain.memeber.entity;

import com.example.fastcampusmysql.util.MemberFixtureFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MemberTest {


    @DisplayName("회원응ㄴ 닉네임을 변경할 수 있다.")
    @Test
    public void testChangeName() {
        Member member = MemberFixtureFactory.create(1L);
        String expected = "donghyun";

        member.changeNickname(expected);

        Assertions.assertEquals(expected, member.getNickname());
    }

    @DisplayName("회원의 닉네임은 10자를 초과할 수 없다.")
    @Test
    public void testNicknameMaxLength() {
        Member member = MemberFixtureFactory.create(1L);
        String expected = "donghyundonghyyun";

        Assertions.assertThrows(IllegalArgumentException.class, () -> member.changeNickname(expected));
    }

}