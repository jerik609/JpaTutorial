package com.jerikthedog.SpringDataJpaTutorial.repository;

import com.jerikthedog.SpringDataJpaTutorial.bidirectionalManyToOne.UserX;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserXRepository extends JpaRepository<UserX, Long> {
}
