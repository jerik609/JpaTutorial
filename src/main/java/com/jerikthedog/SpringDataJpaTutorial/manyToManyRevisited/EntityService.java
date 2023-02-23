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

        //Animal foundAnimal = entityManager.find(Animal.class, 2L);
        Animal catBob = new Animal("cat", "Bob", false);
        entityManager.persist(catBob);

        System.out.println("cat added");

        Person newCatLover = new Person("Emma", 5);

        System.out.println("???");

        // INSERT INTO person VALUES("Emma", 5);
        // INSERT INTO animal_person VALUES(2, 4)
        // this works, since animal is owner of the foreign key, so it will update it too (?)
        //catBob.getPeopleInContact().add(newCatLover);
        catBob.addPerson(newCatLover);

        System.out.println("dog lover person added!!!");

        //newCatLover.getAnimalsInContact().add(catBob);

        entityManager.getTransaction().commit();
        entityManager.clear();
    }

    public void deletePersonFromSet() {
        entityManager.getTransaction().begin();

        Animal foundAnimal = entityManager.find(Animal.class, 1L);
        Person firstPersonFromSet = foundAnimal.getPeopleInContact().iterator().next();

        // DELETE FROM animal_person
        // WHERE animal_id=1 and person_id=1
        // this works, since animal is owner of the foreign key, so it will update it too (?)
        foundAnimal.getPeopleInContact().remove(firstPersonFromSet);

        entityManager.getTransaction().commit();
        entityManager.clear();
    }

    public void addAnimalToSet() {
        entityManager.getTransaction().begin();

        Person foundPerson = new Person("Martina", 10);
        entityManager.persist(foundPerson);
        System.out.println("person added");

                //entityManager.find(Person.class, 3L); // person PK = 3 (this is John)
        Animal newDog = new Animal("dog", "Oscar", false); // Oscar (will get id 4)

        System.out.println("???");

        // now we would normally use
        //foundPerson.getAnimalsInContact().add(newDog);
        // which would cascade (we set up the cascade in Person entity), but it will only update the animal entity, not the join table
        // to update the join table, we need to maintain the consistency of the data, keep the entities in sync
        // for that we will use our special method and update the animal entity too
        // because all updates of the FK need to go via the owner, the join table will be updated now
        foundPerson.addAnimal(newDog);

        System.out.println("cat added");

        entityManager.getTransaction().commit();
        entityManager.clear();
    }

    public void deleteAnimalFromSet() {
        entityManager.getTransaction().begin();

        Person foundPerson = entityManager.find(Person.class, 3L);
        //System.out.println("foundPerson = " + foundPerson);
        Animal firstAnimalFromSet = foundPerson.getAnimalsInContact().iterator().next();
        //System.out.println("firstAnimalFromSet = " + firstAnimalFromSet);

        // now we would normally use
        foundPerson.removeAnimal(firstAnimalFromSet);
        // which would cascade (we set up the cascade in Person entity), but it will only update the animal entity, not the join table
        // to update the join table, we need to maintain the consistency of the data, keep the entities in sync
        // for that we will use our special method and update the animal entity too
        // because all updates of the FK need to go via the owner, the join table will be updated now
        //foundPerson.removeAnimal(firstAnimalFromSet);

        entityManager.getTransaction().commit();
        entityManager.clear();
    }

}
