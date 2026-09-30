package com.yomna.evenement;

import com.yomna.evenement.entities.Evenement;
import com.yomna.evenement.repos.EvenementRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;

import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class EvenementMicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EvenementMicroserviceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(EvenementRepository evenementRepository) {
        return args -> {
            evenementRepository.save(Evenement.builder()
                    .nomEvenement("Festival de Carthage")
                    .lieu("Carthage")
                    .dateEvenement(LocalDate.of(2026, 7, 15))
                    .organisateur("Ministere de la Culture")
                    .email("contact@festival.tn")
                    .build());
        };
    }
}