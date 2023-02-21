package com.jerikthedog.SpringDataJpaTutorial.test;

import com.jerikthedog.SpringDataJpaTutorial.neo_entity.PostgresUser;
import com.jerikthedog.SpringDataJpaTutorial.neo_entity.PostgresUserDetails;
import com.jerikthedog.SpringDataJpaTutorial.repository.PostgresUserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PostgresUserTest {

    @Autowired
    PostgresUserRepository repository;

    @Test
    public void testOneToOne() {
        PostgresUserDetails detais = PostgresUserDetails.builder()
                .email("mooo")
                .location("boooo")
                .name("foooo")
                .build();

        PostgresUser loser = PostgresUser.builder()
                .postgresUserDetails(detais)
                .build();

        repository.save(loser);
    }

}
