package com.jerikthedog.SpringDataJpaTutorial.repository;

import com.jerikthedog.SpringDataJpaTutorial.many2many.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManyManyCourseRepository extends JpaRepository<Course, Long> {
}
