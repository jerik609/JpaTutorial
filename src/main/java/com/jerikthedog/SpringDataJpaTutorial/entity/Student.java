package com.jerikthedog.SpringDataJpaTutorial.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(
        name = "tbl_student", // custom table name
        uniqueConstraints = @UniqueConstraint( // email ID should be unique, as it identifies the student
                name = "emailid_unique",
                columnNames = "email_address"
        )
)
public class Student {

    @Id
    // oracle and postgres are able to provide sequences automatically, but mysql does not have
    // such functionality, so we need to do it explicitly
    @SequenceGenerator( // define a sequence generator for our ID
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue( // use the defined sequence generator
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long studentId;
    private String firstname;
    private String lastname;
    @Column(
            name = "email_address", // custom column name
            nullable = false // email address defines a user uniquely, so it should not be nullable
    )
    private String emailId;

    @Embedded
    private Guardian guardian;


}
