package com.yomna.genre;

import com.yomna.genre.entities.Genre;
import com.yomna.genre.repos.GenreRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GenreMicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GenreMicroserviceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(GenreRepository genreRepository) {
        return args -> {
            genreRepository.save(Genre.builder()
                    .nomGenre("Concert")
                    .codeGenre("CONC")
                    .build());
            genreRepository.save(Genre.builder()
                    .nomGenre("Conference")
                    .codeGenre("CONF")
                    .build());
            genreRepository.save(Genre.builder()
                    .nomGenre("Sport")
                    .codeGenre("SPORT")
                    .build());
        };
    }
}