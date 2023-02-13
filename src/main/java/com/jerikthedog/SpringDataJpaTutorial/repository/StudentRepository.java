package com.jerikthedog.SpringDataJpaTutorial.repository;

import com.jerikthedog.SpringDataJpaTutorial.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    // custom methods

    List<Student> findByFirstname(String firstname);

    List<Student> findByFirstnameContaining(String name);

    List<Student> findByLastnameNotNull();

    // works on embedded classes too - first we provide the name of the embedded member, then member of the member
    List<Student> findByGuardianName(String name);

}
