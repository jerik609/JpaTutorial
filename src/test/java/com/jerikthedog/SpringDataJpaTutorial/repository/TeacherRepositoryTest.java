package com.jerikthedog.SpringDataJpaTutorial.repository;

import com.jerikthedog.SpringDataJpaTutorial.entity.Course2;
import com.jerikthedog.SpringDataJpaTutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher() {

        Course2 course = Course2.builder()
                .title("Knitting")
                .credit(1)
                .build();

        Course2 course2 = Course2.builder()
                .title("Baking")
                .credit(2)
                .build();

        Teacher teacher = Teacher.builder()
                .firstname("John")
                .lastname("Khan")
                //.courseList(List.of(course, course2))
                .build();

        teacherRepository.save(teacher);
    }

}