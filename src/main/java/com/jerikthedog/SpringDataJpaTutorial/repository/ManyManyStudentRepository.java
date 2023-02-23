package com.jerikthedog.SpringDataJpaTutorial.repository;

import com.jerikthedog.SpringDataJpaTutorial.bidirectionalManyToMany.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManyManyStudentRepository extends JpaRepository<Student, Long> {
}
