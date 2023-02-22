package com.jerikthedog.SpringDataJpaTutorial.many2many;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tbl_student")
public class Student {

    @Id
    @GeneratedValue
    private Long studentId;

    @ManyToMany(
            mappedBy = "students", // defines the many to many relationship, states that mapping is done at the other entity
            cascade = CascadeType.ALL
    )
    // @Data generates hashCode and ToString methods with cross-dependent fields and this structure leads to ...
    @ToString.Exclude // ... infinite recursive calls when used with Hibernate
    @EqualsAndHashCode.Exclude // ... infinite recursive calls when used with Hibernate
    @Builder.Default // create an empty HashSet as builder default value
    private Set<Course> courseList = new HashSet<>(); // references to the related entities
}