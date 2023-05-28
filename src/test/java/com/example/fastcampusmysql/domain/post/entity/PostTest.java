package com.example.fastcampusmysql.domain.post.entity;

import com.example.fastcampusmysql.util.PostFixtureFactory;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.stream.IntStream;

class PostTest {


    @Test
    void testCreatePost() {
        EasyRandom random =PostFixtureFactory.get(
                1L,
                LocalDate.of(2023, 5, 1),
                LocalDate.of(2023, 5, 30));

        IntStream.range(1, 5)
                .forEach(i -> System.out.println(random.nextObject(Post.class)));

    }

}