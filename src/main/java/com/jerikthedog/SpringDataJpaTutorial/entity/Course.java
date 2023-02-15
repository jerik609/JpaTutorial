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
public class Course {

    @Id
    @SequenceGenerator(
            name = "course_sequence",
            sequenceName = "course_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_sequence"
    )
    private Long id;
    private String title;
    private Integer credit;

    @OneToOne( // but no joining column, as this is done in course material, so we need to do:
            mappedBy = "course" // the name of the attribute in the CourseMaterial object, which refers to a (the?) course
    )
    private CourseMaterial courseMaterial;

    // we reversed the one-to-many which we defined @ the Teacher class to many-to-one defined here (in Course)
    // so @ Teacher we said - one teacher teaches many courses
    // here we're saying - many courses can be taught by a particular teacher
    @ManyToOne(
            cascade = CascadeType.ALL // so that we can save teacher along the course at the same time (in one save() call)
    )
    @JoinColumn(
            name = "teacher_id", // name of the DB column in the course table, which will contain the foreign key
            referencedColumnName = "id" // id of the Teacher (the actual property name of the Teacher class)
    )
    private Teacher teacher;

}
