package com.jerikthedog.SpringDataJpaTutorial.repository;

import com.jerikthedog.SpringDataJpaTutorial.entity.Guardian;
import com.jerikthedog.SpringDataJpaTutorial.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest // this will result in changes in the database
//@DataJpaTest // this should be used instead, since the changes are not persistent
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Student student = Student.builder()
                .emailId("michal.michal@gmail.com")
                .firstname("Michal")
                .lastname("Mich")
                //.guardianName("Mooo")
                //.guardianEmail("mooo@mooo.mo")
                //.guardianMobile("1234567890")
                .build();
        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian() {
        Guardian guardian = Guardian.builder()
                .name("booo")
                .email("bbb.bbb@bbb.bbb")
                .mobile("39847329874298374")
                .build();

        Student student = Student.builder()
                .firstname("Michal")
                .emailId("michal@michal.sk")
                .lastname("mooo")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudent() {
        List<Student> studentList = studentRepository.findAll();
        System.out.println(studentList);
    }

    @Test
    public void printStudentByFirstname() {
        List<Student> list = studentRepository.findByFirstname("Michal");
        System.out.println("Students: " + list);
    }

    @Test
    public void printStudentByFirstnameContaining() {
        List<Student> list = studentRepository.findByFirstnameContaining("Mic");
        System.out.println("Students: " + list);
    }

    @Test
    public void printStudentByLastnameNotNull() {
        List<Student> list = studentRepository.findByLastnameNotNull();
        System.out.println("lastname not null: " + list);
    }

    @Test
    public void printStudentByGuardianName() {
        List<Student> list = studentRepository.findByGuardianName("booo");
        System.out.println(list);
    }

    @Test
    public void printStudentByFirstnameAndLastname() {
        Student student = studentRepository.findByFirstnameAndLastname("Michal", "mooo");
        System.out.println("student = " + student);
    }

    @Test
    public void printStudentByEmailIdUsingCustomJpqlQuery() {
        Student student = studentRepository.getStudentByEmailAddress("michal@michal.sk");
        System.out.println("student = " + student);
    }

    @Test
    public void printStudentFirstnameByEmailIdUsingCustomJpqlQuery() {
        String firstname = studentRepository.getStudentFirstnameByEmailAddress("michal@michal.sk");
        System.out.println("firstname = " + firstname);
    }

    @Test
    public void printStudentByEmailIdUsingCustomNativeQuery() {
        Student student = studentRepository.getStudentByEmailAddressNative("michal@michal.sk");
        System.out.println("student = " + student);
    }

    @Test
    public void printStudentByEmailIdUsingCustomNativeQueryWithNamedParam() {
        Student student = studentRepository.getStudentByEmailAddressNativeNamedParam("michal@michal.sk", "mooo");
        System.out.println("student = " + student);
    }


}