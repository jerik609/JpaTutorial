package com.jerikthedog.SpringDataJpaTutorial.manyToManyRevisited;

import jakarta.persistence.*;
import lombok.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter @Setter
@NoArgsConstructor
@ToString(exclude="peopleInContact")
@Entity
@Table(name = "animal")
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String species;
    private String name;
    private boolean ruinsFurniture;

    @ManyToMany(mappedBy = "animalsInContact", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Person> peopleInContact = new LinkedHashSet<>();

    public Animal(String species, String name, boolean ruinsFurniture) {
        this.species = species;
        this.name = name;
        this.ruinsFurniture = ruinsFurniture;
    }

    // and the customary add/remove methods on the "mappedBy" entity (non-owner)

    public void addPerson(Person person) {
        peopleInContact.add(person);
        person.getAnimalsInContact().add(this);
    }

    public void removePerson(Person person) {
        peopleInContact.remove(person);
        person.getAnimalsInContact().remove(this);
    }
}