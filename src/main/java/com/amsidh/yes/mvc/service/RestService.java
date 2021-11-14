package com.amsidh.yes.mvc.service;

import com.amsidh.yes.mvc.model.Person;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface RestService {
    public Person savePerson(Person person);
    Person findPerson(Integer personId);
    List<Person> allPersons();
}
