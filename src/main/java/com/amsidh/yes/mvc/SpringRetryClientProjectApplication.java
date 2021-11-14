package com.amsidh.yes.mvc;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.amsidh.yes.mvc.service.RestService;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@RequiredArgsConstructor
@SpringBootApplication
@Slf4j
public class SpringRetryClientProjectApplication implements CommandLineRunner {

    private final RestService restService;

    public static void main(String[] args) {
        SpringApplication.run(SpringRetryClientProjectApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        restService.allPersons().forEach(p -> log.info(p.toString()));

        /*Integer id = 1;
        Person person = restService.findPerson(id);
        log.info("Retrieved Person with person id " + id);
        log.info(person.toString());

        Person p = Person.builder()
                .personName("Aditya Amsidh Lokhande")
                .address("Pune")
                .emailId("aditya@gmail.com")
                .build();
        Person savePerson = restService.savePerson(p);
        log.info("Person Saved");
        log.info(savePerson.toString());*/
    }
}
