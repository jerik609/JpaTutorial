package com.jerikthedog.SpringDataJpaTutorial.test;

import com.jerikthedog.SpringDataJpaTutorial.oneToOneUsingPrimaryKey.PKPostgresUser;
import com.jerikthedog.SpringDataJpaTutorial.oneToOneUsingPrimaryKey.PKPostgresUserDetails;
import com.jerikthedog.SpringDataJpaTutorial.bidirectionalOneToOne.PostgresUser;
import com.jerikthedog.SpringDataJpaTutorial.bidirectionalOneToOne.PostgresUserDetails;
import com.jerikthedog.SpringDataJpaTutorial.repository.PKPostgresUserDetailsRepository;
import com.jerikthedog.SpringDataJpaTutorial.repository.PostgresUserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PostgresUserTest {

    @Autowired
    PostgresUserRepository repository;

    @Autowired
    PKPostgresUserDetailsRepository pkPostgresUserDetailsRepository;

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

    @Test
    public void testOneToOneByPK() {

        PKPostgresUser loser = PKPostgresUser.builder()
                .build();

        PKPostgresUserDetails detais = PKPostgresUserDetails.builder()
                .email("mooo")
                .location("boooo")
                .name("foooo")
                .postgresUser(loser)
                .build();

        pkPostgresUserDetailsRepository.save(detais);
    }


}
