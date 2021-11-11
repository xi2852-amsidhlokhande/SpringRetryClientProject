package com.amsidh.yes.mvc.service.impl;

import com.amsidh.yes.mvc.model.Person;
import com.amsidh.yes.mvc.service.RestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class RestServiceImpl implements RestService {

    RestTemplate restTemplate;

    public RestServiceImpl() {

        this.restTemplate = new RestTemplate();
    }

    //@Retryable(value = RuntimeException.class)
    @Retryable(value = {RuntimeException.class}, maxAttempts = 10, backoff = @Backoff(delay = 2000), recover = "allPersonsRecover")
    @Override
    public List<Person> allPersons() {
        ResponseEntity<List<Person>> exchange = restTemplate.exchange("http://localhost:8181/persons", HttpMethod.GET, null, new ParameterizedTypeReference<List<Person>>() {
        });
        return exchange.getBody();
    }

    @Recover
    public List<Person> allPersonsRecover(RuntimeException runtimeException) {
        List<Person> list = new ArrayList<>();
        return list;
    }
}
