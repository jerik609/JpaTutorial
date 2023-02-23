package com.jerikthedog.SpringDataJpaTutorial.manyToManyRevisited;

import jakarta.persistence.*;
import lombok.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter @Setter
@NoArgsConstructor
@ToString(exclude="animalsInContact")
@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private int freeHours;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "person_animal",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "animal_id"))
    private Set<Animal> animalsInContact = new LinkedHashSet<>();

    public Person(String name, int freeHours) {
        this.name = name;
        this.freeHours = freeHours;
    }

    // and the customary add/remove methods on the "mappedBy" entity (non-owner)

    public void addAnimal(Animal animal) {
        animalsInContact.add(animal);
        animal.getPeopleInContact().add(this);
    }

    public void removeAnimal(Animal animal) {
        animalsInContact.remove(animal);
        animal.getPeopleInContact().remove(this);
    }
}
