package com.jerikthedog.SpringDataJpaTutorial.repository;

import com.jerikthedog.SpringDataJpaTutorial.one2many.Tweet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OneToManyTweetRepository extends JpaRepository<Tweet, Long> {
}
