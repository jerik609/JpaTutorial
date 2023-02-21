package com.jerikthedog.SpringDataJpaTutorial.repository;

import com.jerikthedog.SpringDataJpaTutorial.neo_entity.PostgresUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostgresUserRepository extends JpaRepository<PostgresUser, Long> {
}
