package com.amsidh.yes.mvc.service.impl;

import com.amsidh.yes.mvc.model.Person;
import com.amsidh.yes.mvc.service.RestService;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class RestServiceImpl implements RestService {

    private final RestTemplate restTemplate;

    @Override
    public Person savePerson(Person person) {
        return null;
    }

    @Override
    public Person findPerson(Integer personId) {
        return null;
    }

    @Retry(name = "allPerson-retry-instance")
    @Override
    public List<Person> allPersons() {
        ResponseEntity<List<Person>> exchange = restTemplate.exchange("http://localhost:8181/persons", HttpMethod.GET, null, new ParameterizedTypeReference<List<Person>>() {
        });
        return exchange.getBody();
    }

}
