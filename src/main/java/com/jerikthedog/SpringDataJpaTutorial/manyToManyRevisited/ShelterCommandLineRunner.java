package com.jerikthedog.SpringDataJpaTutorial.manyToManyRevisited;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.sound.midi.Soundbank;

@Component
public class ShelterCommandLineRunner implements CommandLineRunner {

    @Autowired
    EntityService entityService;

    @Override
    public void run(String... args) {

        System.out.println("=================== SHELTER ==================");

        entityService.insertEntities();
        //other EntityService methods

        System.out.println("--------------- init done ------------------");

        entityService.addPersonToSet();

        System.out.println("-----------------------------------------");

        entityService.deletePersonFromSet();

        System.out.println("=========================================");

        entityService.addAnimalToSet();

        System.out.println("-----------------------------------------");

        entityService.deleteAnimalFromSet();

        System.out.println("=================== SHELTER ==================");
    }
}
