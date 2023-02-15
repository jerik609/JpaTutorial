package com.jerikthedog.SpringDataJpaTutorial.repository;

import com.jerikthedog.SpringDataJpaTutorial.entity.Course;
import com.jerikthedog.SpringDataJpaTutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher() {

        Course course = Course.builder()
                .title("Knitting")
                .credit(1)
                .build();

        Course course2 = Course.builder()
                .title("Baking")
                .credit(2)
                .build();

        Teacher teacher = Teacher.builder()
                .firstname("John")
                .lastname("Khan")
                .courseList(List.of(course, course2))
                .build();

        teacherRepository.save(teacher);
    }

}