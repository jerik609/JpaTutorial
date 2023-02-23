package com.jerikthedog.SpringDataJpaTutorial.plainVanilla;

// one teacher can teach many courses -> one:many
// many courses can be taught by one teacher -> many:one

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
public class Teacher {

    @Id
    @SequenceGenerator(
            name = "teacher_sequence",
            sequenceName = "teacher_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "teacher_sequence"
    )
    private Long id;
    private String firstname;
    private String lastname;

//    @OneToMany(
//            cascade = CascadeType.ALL
//    )
//    // each course will have a teacher id, who teaches it
//    @JoinColumn(
//            name = "teacher_id", // name of the column containing the teacher id in the course table
//            referencedColumnName = "id" // teacher id from this entity (= id)
//    )
//    private List<Course> courseList;

    // many to one -> there are many courses available, and they are taught by one teacher
    // JPA recommends to use ManyToOne instead of OneToMany (teacher -> list of courses)
    // so, we comment out the one-to-many above (^^^) and define many-to-one
    // this will go to the Course class of course -> see you there :-)
}
