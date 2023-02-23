package com.jerikthedog.SpringDataJpaTutorial.manyToManyRevisited;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Set;

@Component
public class EntityService {

    private EntityManager entityManager;

    @Autowired
    public EntityService(EntityManagerFactory entityManagerFactory) {
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    public void insertEntities() {
        entityManager.getTransaction().begin();

        Animal catLeo = new Animal("cat", "Leo", false);
        Animal dogCharlie = new Animal("dog", "Charlie", true);
        Animal dogBella = new Animal("dog", "Bella", false);

        Person catLover1 = new Person("James", 8);
        Person catLover2 = new Person("Mary", 6);
        Person dogLover1 = new Person("John", 4);

        catLeo.setPeopleInContact(Set.of(catLover1, catLover2));
        dogCharlie.getPeopleInContact().add(dogLover1);
        dogBella.getPeopleInContact().add(dogLover1);

        catLover1.getAnimalsInContact().add(catLeo);
        catLover2.getAnimalsInContact().add(catLeo);
        dogLover1.setAnimalsInContact(Set.of(dogCharlie, dogBella));

        entityManager.persist(catLeo);
        entityManager.persist(dogCharlie);
        entityManager.persist(dogBella);

        entityManager.getTransaction().commit();
        entityManager.clear();
    }

    public void addPersonToSet() {
        entityManager.getTransaction().begin();

        Animal foundAnimal = entityManager.find(Animal.class, 2L);
        Person newDogLover = new Person("Emma", 5);

        // INSERT INTO person VALUES("Emma", 5);
        // INSERT INTO animal_person VALUES(2, 4)
        foundAnimal.getPeopleInContact().add(newDogLover);

        entityManager.getTransaction().commit();
        entityManager.clear();
    }

    public void deletePersonFromSet() {
        entityManager.getTransaction().begin();

        Animal foundAnimal = entityManager.find(Animal.class, 1L);
        Person firstPersonFromSet = foundAnimal.getPeopleInContact().iterator().next();

        // DELETE FROM animal_person
        // WHERE animal_id=1 and person_id=1
        foundAnimal.getPeopleInContact().remove(firstPersonFromSet);

        entityManager.getTransaction().commit();
        entityManager.clear();
    }

    public void addAnimalToSet() {
        entityManager.getTransaction().begin();

        Person foundPerson = entityManager.find(Person.class, 3L); // person PK = 3 (this is John)
        Animal newDog = new Animal("dog", "Oscar", false); // Oscar (will get id 4)

        // "foundPerson.getAnimalsInContact().add(newDog)" doesn't generate a query, if not (see comments):
        foundPerson.getAnimalsInContact().add(newDog); // must add cascading to Person mapping, otherwise the newDog entry will not be propagated (& persisted)
        newDog.getPeopleInContact().add(foundPerson); // and then we must add the opposite mapping, so that the jointable is updated

        entityManager.getTransaction().commit();
        entityManager.clear();
    }

    public void deleteAnimalFromSet() {
        entityManager.getTransaction().begin();

        Person foundPerson = entityManager.find(Person.class, 3L);
        System.out.println("foundPerson = " + foundPerson);
        Animal firstAnimalFromSet = foundPerson.getAnimalsInContact().iterator().next();
        System.out.println("firstAnimalFromSet = " + firstAnimalFromSet);
        
        //doesn't generate a query
        foundPerson.getAnimalsInContact().remove(firstAnimalFromSet);
        firstAnimalFromSet.getPeopleInContact().remove(foundPerson); // must remove also from other side

        // HOW TO FIX THIS? add cascade!?
        //entityManager.persist(foundPerson);

//        entityManager.persist(firstAnimalFromSet);

        entityManager.getTransaction().commit();
        entityManager.clear();
    }

}
