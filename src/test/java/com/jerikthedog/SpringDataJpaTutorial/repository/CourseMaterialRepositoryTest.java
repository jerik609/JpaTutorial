package com.jerikthedog.SpringDataJpaTutorial.repository;

import com.jerikthedog.SpringDataJpaTutorial.entity.Course;
import com.jerikthedog.SpringDataJpaTutorial.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Test
    public void SaveCourseMaterial() {

        Course course = Course.builder()
                .credit(6)
                .title("Google Course")
                .build();

        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("www.google.com")
                .course(course)
                .build();

        // doing just this will not work, because of course, it must be saved first
        // we could of course autowire the course repository and save the course, but let's do
        // CASCADING!
        courseMaterialRepository.save(courseMaterial);
    }


}