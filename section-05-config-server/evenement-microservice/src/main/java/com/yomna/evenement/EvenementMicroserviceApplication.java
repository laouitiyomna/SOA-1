package com.yomna.evenement;

import com.yomna.evenement.entities.Evenement;
import com.yomna.evenement.repos.EvenementRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.LocalDate;

@SpringBootApplication
@EnableFeignClients
public class EvenementMicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EvenementMicroserviceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(EvenementRepository evenementRepository) {
        return args -> evenementRepository.save(Evenement.builder()
                .nomEvenement("Festival de Carthage")
                .lieu("Carthage")
                .dateEvenement(LocalDate.of(2026, 7, 15))
                .organisateur("Ministère de la Culture")
                .email("contact@festival.tn")
                .codeGenre("CONC")
                .build());
    }

    @Bean
    public WebClient webClient() {
        return WebClient.builder().build();
    }
}
