package com.jerikthedog.SpringDataJpaTutorial.repository;

import com.jerikthedog.SpringDataJpaTutorial.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    // https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#transactions
    /*
    By default, CRUD methods on repository instances inherited from SimpleJpaRepository are transactional.
    For read operations, the transaction configuration readOnly flag is set to true.
    All others are configured with a plain @Transactional so that default transaction configuration applies.
    Repository methods that are backed by transactional repository fragments inherit the transactional attributes
    from the actual fragment method.
     */
}
