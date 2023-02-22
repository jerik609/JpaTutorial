package com.jerikthedog.SpringDataJpaTutorial.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Course2 {

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
            mappedBy = "course2" // the name of the attribute in the CourseMaterial object, which refers to a (the?) course
    )
    private CourseMaterial courseMaterial;

    // Vlad says, use ManyToOne by default - it should mostly suffice :-)
    // -> the List<Child> is a dangerous thing ..., lazy is dangerous, etc ... see README.md for more info
    // https://vladmihalcea.com/the-best-way-to-map-a-onetomany-association-with-jpa-and-hibernate/

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

    // MANY-TO-MANY
    // many to many with student!

    @ManyToMany(
            cascade = CascadeType.ALL // enable to insert/update/delete all related (provided) entities in cascade
    )
    @JoinTable( // this defines the third table
            name = "student_course_map", // the name of the new table :-)
            joinColumns = @JoinColumn( // how we (course) join to the new table
                    name = "course_id",
                    referencedColumnName = "id" // referenced here is the course (course id) = this is the id of the course!
            ),
            inverseJoinColumns = @JoinColumn( // how does the other (counter-)entity (student) join with this new table
                    name = "student_id",
                    referencedColumnName = "studentId" // the id at the Students side of things
            )
    ) // the sql statements will probably be a messy pile of complex obscure woohoo
    private List<Student2> student2s; // actually it's very simple (inefficient, but simple - such things always are)

    public void addStudents(Student2 student2) {
        if (student2s == null) student2s = new ArrayList<>();
        student2s.add(student2);
    }

}
