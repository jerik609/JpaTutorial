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
public class CourseMaterial {




    @Id
    @SequenceGenerator(
            name = "course_material_sequence",
            sequenceName = "course_material_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_material_sequence"
    )
    private Long id;
    private String url;

    // there's a 1:1 relationship with course, in fact, course material cannot exist w/o a course
    // we will define a foreign key constraint
    @OneToOne( // the relationship is one to one
            cascade = CascadeType.ALL // cascade tells JPA to save any associated entities (ALL = apply all necessary operations, "don't think about it too much")
    )
    // finally, we need to define which column is the foreign key
    @JoinColumn(
            name = "course_id", // the name of the column of this entity (in the DB), which will contain the foreign key value
            referencedColumnName = "id" // the name of the column of the referenced entity, which contains the foreign key
    )
    private Course course;

}