package com.jerikthedog.SpringDataJpaTutorial.bidirectionalManyToMany;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tbl_course")
public class Course {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToMany(
            cascade = CascadeType.ALL // enable automatic insert/update/delete of all related (provided) entities in cascade
    )
    @JoinTable( // this defines the join table
            name = "tbl_student_course_map", // the name of the join table
            joinColumns = @JoinColumn( // how entity Course maps to the join table
                    name = "course_id", // name of column holding the foreign key in the join table
                    referencedColumnName = "id" // the referenced column is the primary key of the course, the ID of this entity (this = Course)
            ),
            inverseJoinColumns = @JoinColumn( // how does the other (counter-)entity (Student) map to the join table
                    name = "student_id", // name of the column in the join table, holding the foreign key
                    referencedColumnName = "studentId" // the primary key of the student entity, which the foreign key refers to
            )
    )
    // @Data generates hashCode and ToString methods with cross-dependent fields and this structure leads to ...
    @ToString.Exclude // ... infinite recursive calls when used with Hibernate
    @EqualsAndHashCode.Exclude // ... infinite recursive calls when used with Hibernate
    @Builder.Default // create an empty HashSet as builder default value
    private Set<Student> students = new HashSet<>(); // reference(s) to the related entities

    public void addStudent(Student s) {
        this.students.add(s);
        s.getCourseList().add(this);
    }

    public void removeStudent(Student s) {
        this.students.remove(s);
        s.getCourseList().remove(this);
    }
}
