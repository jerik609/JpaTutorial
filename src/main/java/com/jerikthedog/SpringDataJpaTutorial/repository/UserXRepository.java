package com.jerikthedog.SpringDataJpaTutorial.repository;

import com.jerikthedog.SpringDataJpaTutorial.entity2.UserX;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserXRepository extends JpaRepository<UserX, Long> {
}
