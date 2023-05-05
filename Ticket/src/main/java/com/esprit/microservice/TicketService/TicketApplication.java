package com.esprit.microservice.TicketService;

import java.util.stream.Stream;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import com.esprit.microservice.TicketService.Entity.Ticket;
import com.esprit.microservice.TicketService.Repositories.TicketRepository;

@SpringBootApplication
@EnableEurekaClient
public class TicketApplication {

	public static void main(String[] args) {
		SpringApplication.run(TicketApplication.class, args);
	}
	
	 @Bean
	    ApplicationRunner init(TicketRepository repository) {
	        return args -> {
	            Stream.of("ZTG2MO", "SVM8YU", "BSJH10").forEach(reference -> {
	                repository.save(new Ticket(reference));
	            });
	            repository.findAll().forEach(System.out::println);
	        };
	    }

}
