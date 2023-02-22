package com.jerikthedog.SpringDataJpaTutorial.many2many;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tbl_student")
public class Student {

    @Id
//    @SequenceGenerator(
//            name = "student_seq_gen",
//            sequenceName = "student_seq_gen",
//            allocationSize = 1
//    )
//    @GeneratedValue(
//            strategy = GenerationType.SEQUENCE,
//            generator = "student_seq_gen"
//    )
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long studentId;

    @ManyToMany(mappedBy = "students", cascade = CascadeType.ALL)
    private List<Course> courseList;

}
