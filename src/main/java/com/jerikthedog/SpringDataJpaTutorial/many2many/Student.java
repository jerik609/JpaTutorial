package com.jerikthedog.SpringDataJpaTutorial.many2many;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {

    @Id
    @GeneratedValue
    private Long studentId;

    @ManyToMany(mappedBy = "students", cascade = CascadeType.ALL)
    private List<Course> courseList;

}
