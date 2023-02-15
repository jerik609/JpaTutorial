package com.jerikthedog.SpringDataJpaTutorial.repository;

import com.jerikthedog.SpringDataJpaTutorial.entity.Course;
import com.jerikthedog.SpringDataJpaTutorial.entity.CourseMaterial;
import com.jerikthedog.SpringDataJpaTutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;


    @Test
    public void printCourses() {
        List<Course> courses = courseRepository.findAll();
        System.out.println("courses = " + courses);

        // how do we get the course materials?
        // the course material has reference to the course and the relationship defined
        // when we get the course material, we immediately get the courses (well, if not lazy) :-)

        // in courses, we have no reference to course materials, because the relationship between
        // course materials and courses is unidirectional

        // so how do we get the course materials when we have a course?
        // so how do we create a bidirectional relationship?
    }

    @Test
    public void saveCourseWithTeacher() {

        Teacher teacher = Teacher.builder()
                .firstname("Peter")
                .lastname("Black")
                .build();

        Course course = Course.builder()
                .credit(30)
                .title("brain surgery")
                .teacher(teacher)
                .build();

        courseRepository.save(course);
    }


}