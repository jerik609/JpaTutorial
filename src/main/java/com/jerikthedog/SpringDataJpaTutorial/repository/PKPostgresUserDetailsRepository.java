package com.jerikthedog.SpringDataJpaTutorial.repository;


import com.jerikthedog.SpringDataJpaTutorial.OneToOneUsingPrimaryKey.PKPostgresUserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PKPostgresUserDetailsRepository extends JpaRepository<PKPostgresUserDetails, Long> {
}
