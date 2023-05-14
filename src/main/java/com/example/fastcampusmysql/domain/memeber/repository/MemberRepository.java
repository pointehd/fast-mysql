package com.example.fastcampusmysql.domain.memeber.repository;

import com.example.fastcampusmysql.domain.memeber.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class MemberRepository {

    final private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public Member save(Member member){
        if(member.getId() == null) {
            return insert(member);
        }
        return member;
    }


    private Member insert(Member member) {
        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(namedParameterJdbcTemplate.getJdbcTemplate())
                .withTableName("Member")
                .usingGeneratedKeyColumns("id");
        SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(member);
        long id = simpleJdbcInsert.executeAndReturnKey(parameterSource).longValue();
        return Member
                .builder()
                .id(id)
                .email(member.getEmail())
                .nickname(member.getNickname())
                .birthday(member.getBirthday())
                .createdAt(member.getCreatedAt())
                .build();
    }

    private Member update(Member member) {
        return member;
    }
}
