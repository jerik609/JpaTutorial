package com.jerikthedog.SpringDataJpaTutorial.repository;

import com.jerikthedog.SpringDataJpaTutorial.entity.Course2;
import com.jerikthedog.SpringDataJpaTutorial.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Course2MaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Test
    public void SaveCourseMaterial() {

        Course2 course2 = Course2.builder()
                .credit(6)
                .title("Google Course")
                .build();

        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("www.google.com")
                .course2(course2) // since optional is false on course material entity, course must be always provided!
                .build();

        // doing just this will not work, because of course, it must be saved first
        // we could of course autowire the course repository and save the course, but let's do
        // CASCADING - enable cascading on the course material entity (off by default)
        courseMaterialRepository.save(courseMaterial);
    }

    @Test
    public void printAllCourseMaterials() {
        List<CourseMaterial> courseMaterials = courseMaterialRepository.findAll();
        System.out.println("courseMaterials = " + courseMaterials);
    }


}