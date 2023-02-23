package com.jerikthedog.SpringDataJpaTutorial.repository;

import com.jerikthedog.SpringDataJpaTutorial.plainVanilla.Guardian;
import com.jerikthedog.SpringDataJpaTutorial.plainVanilla.Student2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest // this will result in changes in the database
//@DataJpaTest // this should be used instead, since the changes are not persistent
class Student2RepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Student2 student2 = Student2.builder()
                .emailId("michal.michal@gmail.com")
                .firstname("Michal")
                .lastname("Mich")
                //.guardianName("Mooo")
                //.guardianEmail("mooo@mooo.mo")
                //.guardianMobile("1234567890")
                .build();
        studentRepository.save(student2);
    }

    @Test
    public void saveStudentWithGuardian() {
        Guardian guardian = Guardian.builder()
                .name("booo")
                .email("bbb.bbb@bbb.bbb")
                .mobile("39847329874298374")
                .build();

        Student2 student2 = Student2.builder()
                .firstname("Michal")
                .emailId("michal@michal.sk")
                .lastname("mooo")
                .guardian(guardian)
                .build();

        studentRepository.save(student2);
    }

    @Test
    public void printAllStudent() {
        List<Student2> student2List = studentRepository.findAll();
        System.out.println(student2List);
    }

    @Test
    public void printStudentByFirstname() {
        List<Student2> list = studentRepository.findByFirstname("Michal");
        System.out.println("Students: " + list);
    }

    @Test
    public void printStudentByFirstnameContaining() {
        List<Student2> list = studentRepository.findByFirstnameContaining("Mic");
        System.out.println("Students: " + list);
    }

    @Test
    public void printStudentByLastnameNotNull() {
        List<Student2> list = studentRepository.findByLastnameNotNull();
        System.out.println("lastname not null: " + list);
    }

    @Test
    public void printStudentByGuardianName() {
        List<Student2> list = studentRepository.findByGuardianName("booo");
        System.out.println(list);
    }

    @Test
    public void printStudentByFirstnameAndLastname() {
        Student2 student2 = studentRepository.findByFirstnameAndLastname("Michal", "mooo");
        System.out.println("student = " + student2);
    }

    @Test
    public void printStudentByEmailIdUsingCustomJpqlQuery() {
        Student2 student2 = studentRepository.getStudentByEmailAddress("michal@michal.sk");
        System.out.println("student = " + student2);
    }

    @Test
    public void printStudentFirstnameByEmailIdUsingCustomJpqlQuery() {
        String firstname = studentRepository.getStudentFirstnameByEmailAddress("michal@michal.sk");
        System.out.println("firstname = " + firstname);
    }

    @Test
    public void printStudentByEmailIdUsingCustomNativeQuery() {
        Student2 student2 = studentRepository.getStudentByEmailAddressNative("michal@michal.sk");
        System.out.println("student = " + student2);
    }

    @Test
    public void printStudentByEmailIdUsingCustomNativeQueryWithNamedParam() {
        Student2 student2 = studentRepository.getStudentByEmailAddressNativeNamedParam("michal@michal.sk", "mooo");
        System.out.println("student = " + student2);
    }

    @Test
    public void modifyStudentFirstnameByEmailId() {
        int num = studentRepository.updateStudentNameByEmailId("Moochal", "michal@michal.sk");
        System.out.println("num = " + num);
    }

}