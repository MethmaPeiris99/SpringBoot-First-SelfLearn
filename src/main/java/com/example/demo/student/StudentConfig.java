package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.time.Month.FEBRUARY;
import static java.time.Month.JANUARY;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student methma = new Student(
                    "Methma",
                    "methma34@gmail.com",
                    LocalDate.of(1999, FEBRUARY,3),
                    22
            );

            Student oshadhi = new Student(
                    "Oshadhi",
                    "oshadhi@gmail.com",
                    LocalDate.of(2000, JANUARY,18),
                    21
            );
            repository.saveAll(
                    List.of(methma,oshadhi)
            );
        };
    }
}
