package com.jerikthedog.SpringDataJpaTutorial.repository;

import com.jerikthedog.SpringDataJpaTutorial.entity.Course;
import com.jerikthedog.SpringDataJpaTutorial.entity.Student;
import com.jerikthedog.SpringDataJpaTutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

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

    // PAGING!
    @Test
    public void findAppPagination() {
        Pageable firstPageWithThreeRecords = PageRequest.of(0, 3); // page 0 is the first page
        Pageable secondPageWithTwoRecords = PageRequest.of(1, 2);

        Page<Course> pageOne = courseRepository.findAll(firstPageWithThreeRecords);
        Page<Course> pageTwo = courseRepository.findAll(secondPageWithTwoRecords);

        List<Course> courses = pageOne.getContent();
        List<Course> courses2 = pageTwo.getContent();

        System.out.println("total pages = " + pageOne.getTotalPages());
        System.out.println("total elements = " + pageOne.getTotalElements());
        System.out.println("courses = " + courses);

        System.out.println("total pages = " + pageTwo.getTotalPages());
        System.out.println("total elements = " + pageTwo.getTotalElements());
        System.out.println("courses2 = " + courses2);
    }

    // SORTING!
    @Test
    public void findAllSorting() {
        Pageable sortByTitle = PageRequest.of(0, 3, Sort.by("title"));

        Pageable sortByCreditDesc = PageRequest.of(0, 3, Sort.by("credit").descending());

        Pageable sortByCreditDescAndTitleAsc = PageRequest.of(0, 4, Sort.by("credit").descending().and(Sort.by("title").ascending()));

        Page<Course> page = courseRepository.findAll(sortByTitle);

        System.out.println("total pages = " + page.getTotalPages());
        System.out.println("total elements = " + page.getTotalElements());
        System.out.println("courses = " + page.getContent());

        Page<Course> pageX = courseRepository.findAll(sortByCreditDescAndTitleAsc);

        System.out.println("X:total pages = " + pageX.getTotalPages());
        System.out.println("X:total elements = " + pageX.getTotalElements());
        System.out.println("X:courses = " + pageX.getContent());
    }

    // PAGING using custom find method defined via JPQL in the repository
    @Test
    public void findByTitleContainingPaging() {
        Pageable firstPageTenRecords = PageRequest.of(0, 10);

        List<Course> list = courseRepository.findByTitleContaining("brain", firstPageTenRecords).getContent();

        System.out.println("list = " + list);
    }

    @Test
    public void saveCourseWithStudentAndTeacher() {
        Teacher teacher = Teacher.builder()
                .firstname("Lizze")
                .lastname("Morgan")
                .build();

        Course course = Course.builder()
                .title("JPA stuff moo")
                .credit(100)
                .teacher(teacher)
                .build();

        Student student = Student.builder()
                .firstname("Abhishek")
                .lastname("Singh")
                .emailId("abishek@abi.com")
                .build();

        course.addStudents(student);

        courseRepository.save(course);
    }

}