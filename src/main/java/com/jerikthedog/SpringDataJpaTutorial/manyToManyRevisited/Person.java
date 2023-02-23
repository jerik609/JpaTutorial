package com.jerikthedog.SpringDataJpaTutorial.manyToManyRevisited;

import jakarta.persistence.*;
import lombok.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter @Setter
@NoArgsConstructor
@ToString(exclude="animalsInContact")
@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private int freeHours;

    @ManyToMany(mappedBy = "peopleInContact", cascade = {CascadeType.PERSIST})
    private Set<Animal> animalsInContact = new LinkedHashSet<>();

    public Person(String name, int freeHours) {
        this.name = name;
        this.freeHours = freeHours;
    }
}
