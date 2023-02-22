package com.jerikthedog.SpringDataJpaTutorial.repository;

import com.jerikthedog.SpringDataJpaTutorial.many2many.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManyManyStudentRepository extends JpaRepository<Student, Long> {
}
