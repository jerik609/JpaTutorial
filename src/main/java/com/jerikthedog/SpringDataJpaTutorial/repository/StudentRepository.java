package com.jerikthedog.SpringDataJpaTutorial.repository;

import com.jerikthedog.SpringDataJpaTutorial.plainVanilla.Student2;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

// https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods

@Repository
public interface StudentRepository extends JpaRepository<Student2, Long> {

    // custom methods

    List<Student2> findByFirstname(String firstname);

    List<Student2> findByFirstnameContaining(String name);

    List<Student2> findByLastnameNotNull();

    // works on embedded classes too - first we provide the name of the embedded member, then member of the member
    List<Student2> findByGuardianName(String name);

    Student2 findByFirstnameAndLastname(String firstname, String lastname);

    // this is an example, where the automatically built JPQL is not enough, and we want our own query
    // on purpose we use get to avoid building a JPQL automatically
    // so we will provide our own JPQL query ... note that this means, that we will be working
    // with the class names, not the table names in the query ... it IS NOT SQL, it just looks
    // similar
    // JPQL
    @Query("select s from Student2 s where s.emailId = ?1") // JPQL // ?1 = first attribute
    Student2 getStudentByEmailAddress(String emailId);

    // JPQL with single return value
    @Query("select s.firstname from Student2 s where s.emailId = ?1") // JPQL // ?1 = first attribute
    String getStudentFirstnameByEmailAddress(String emailId);

    // Assume we have very complex objects/logic where JPQL will not help, so we need native SQL queries
    // Native Query
    @Query(
            value = "SELECT * FROM tbl_student s WHERE s.email_address = ?1",
            nativeQuery = true
    )
    Student2 getStudentByEmailAddressNative(String emailId);

    // ?1, ?2, ?3 for parameters is not always a good thing, but we can define named parameters
    // Native Query with named param
    @Query(
            value = "SELECT * FROM tbl_student s WHERE s.email_address = :emailId AND s.lastname = :lastname",
            nativeQuery = true // NATIVE SQL QUERY!
    )
    Student2 getStudentByEmailAddressNativeNamedParam(
            @Param("emailId") String emailId,
            @Param("lastname") String lastname
            // there can of course be multiple named param here :-)
    );


    // modifying data

    // we're defining the @Transactional on repository, but since we'd typically perform
    // several repository updates in the service layer, so the transactional
    // would go there to perform the modifications in one transaction
    // @Transactional can be placed on a method and also on a class
    @Modifying // only needed on methods annotated by @Query, when changing data in DB. it's not needed for DSL defined JPQL update queries (those w/o @Query)
    @Transactional // and we need to perform it within a transaction too (otherwise it throws an error)
    @Query(
            value = "update tbl_student s set s.firstname = ?1 where s.email_address = ?2",
            nativeQuery = true
    )
    int updateStudentNameByEmailId(String firstname, String emailId);

    // @Modifying changes the "execution method" from executeQuery to executeUpdate

    // @Transactional vs private ?

    // https://www.baeldung.com/transaction-configuration-with-jpa-and-spring

    // transactions are implemented via proxies - which wrap the methods - they establish the transaction and then either commit or rollback
    // behavior of readonly transaction is weird (??)
    // two problems:
    // - private methods are not proxied
    // - when implementing an interface, only external calls are proxied

}
