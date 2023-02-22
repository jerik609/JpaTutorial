package com.jerikthedog.SpringDataJpaTutorial.many2many;

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
public class Course {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToMany(
            cascade = CascadeType.ALL // enable to insert/update/delete all related (provided) entities in cascade
    )
    @JoinTable( // this defines the third table
            name = "student_course_map", // the name of the new table :-)
            joinColumns = @JoinColumn( // how we (course) join to the new table
                    name = "course_id", // name of column holding the foreign key in the join table
                    referencedColumnName = "id" // the referenced column is the primary key of the course, the ID of this entity (this = course)
            ),
            inverseJoinColumns = @JoinColumn( // how does the other (counter-)entity (student) join with this new table
                    name = "student_id", // name of the column in the join table, holding the foreign key
                    referencedColumnName = "studentId" // the primary key of the student entity, which the foreign key refers to
            )
    ) // the sql statements will probably be a messy pile of complex obscure woohoo
    private List<Student> students; // actually it's very simple (inefficient, but simple - such things always are)

    public void addStudents(Student student) {
        if (students == null) students = new ArrayList<>();
        students.add(student);
    }

}
