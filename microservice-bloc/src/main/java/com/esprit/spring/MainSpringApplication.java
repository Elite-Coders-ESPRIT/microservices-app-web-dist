package com.esprit.spring;

import com.esprit.spring.entities.Bloc;
import com.esprit.spring.repo.BlocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MainSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(MainSpringApplication.class, args);
    }

    @Autowired
    BlocRepository blocRepository;

    @Bean
    ApplicationRunner init(){
        return (args -> {
           blocRepository.save(new Bloc("A",200L));
           blocRepository.save(new Bloc("B",400L));
           blocRepository.save(new Bloc("C",600L));
           blocRepository.findAll().forEach(System.out::println);
        });
    }

}
