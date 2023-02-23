package com.jerikthedog.SpringDataJpaTutorial.repository;


import com.jerikthedog.SpringDataJpaTutorial.oneToOneUsingPrimaryKey.PKPostgresUserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PKPostgresUserDetailsRepository extends JpaRepository<PKPostgresUserDetails, Long> {
}
