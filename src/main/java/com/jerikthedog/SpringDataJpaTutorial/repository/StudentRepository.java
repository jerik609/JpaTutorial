package com.jerikthedog.SpringDataJpaTutorial.repository;

import com.jerikthedog.SpringDataJpaTutorial.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

// https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    // custom methods

    List<Student> findByFirstname(String firstname);

    List<Student> findByFirstnameContaining(String name);

    List<Student> findByLastnameNotNull();

    // works on embedded classes too - first we provide the name of the embedded member, then member of the member
    List<Student> findByGuardianName(String name);

    Student findByFirstnameAndLastname(String firstname, String lastname);

    // this is an example, where the automatically built JPQL is not enough, and we want our own query
    // on purpose we use get to avoid building a JPQL automatically
    // so we will provide our own JPQL query ... note that this means, that we will be working
    // with the class names, not the table names in the query ... it IS NOT SQL, it just looks
    // similar
    // JPQL
    @Query("select s from Student s where s.emailId = ?1") // JPQL // ?1 = first attribute
    Student getStudentByEmailAddress(String emailId);

    // JPQL with single return value
    @Query("select s.firstname from Student s where s.emailId = ?1") // JPQL // ?1 = first attribute
    String getStudentFirstnameByEmailAddress(String emailId);

    // Assume we have very complex objects/logic where JPQL will not help, so we need native SQL queries
    // Native Query
    @Query(
            value = "SELECT * FROM tbl_student s WHERE s.email_address = ?1",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNative(String emailId);

    // ?1, ?2, ?3 for parameters is not always a good thing, but we can define named parameters
    // Native Query with named param
    @Query(
            value = "SELECT * FROM tbl_student s WHERE s.email_address = :emailId AND s.lastname = :lastname",
            nativeQuery = true // NATIVE SQL QUERY!
    )
    Student getStudentByEmailAddressNativeNamedParam(
            @Param("emailId") String emailId,
            @Param("lastname") String lastname
            // there can of course be multiple named param here :-)
    );

}
