package com.amsidh.yes.mvc;

import com.amsidh.yes.mvc.service.RestService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

@Data
@RequiredArgsConstructor
@SpringBootApplication
@EnableRetry
public class SpringRetryClientProjectApplication implements CommandLineRunner {

	private final RestService restService;

	public static void main(String[] args) {
		SpringApplication.run(SpringRetryClientProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		restService.allPersons().forEach(System.out::println);

		//restService.service1("Amsidh1","Lokhande1");
		//restService.service2("Amsidh2","Lokhande2");
	}
}
