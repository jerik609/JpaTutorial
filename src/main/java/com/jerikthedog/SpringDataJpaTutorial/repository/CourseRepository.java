package com.jerikthedog.SpringDataJpaTutorial.repository;

import com.jerikthedog.SpringDataJpaTutorial.plainVanilla.Course2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// every JpaRepository extends a paging and sorting repository

@Repository
public interface CourseRepository extends JpaRepository<Course2, Long> {
    // https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#transactions
    /*
    By default, CRUD methods on repository instances inherited from SimpleJpaRepository are transactional.
    For read operations, the transaction configuration readOnly flag is set to true.
    All others are configured with a plain @Transactional so that default transaction configuration applies.
    Repository methods that are backed by transactional repository fragments inherit the transactional attributes
    from the actual fragment method.
     */

    // custom sorting method

    Page<Course2> findByTitleContaining(
            String title,
            Pageable pageRequest
    );

}
