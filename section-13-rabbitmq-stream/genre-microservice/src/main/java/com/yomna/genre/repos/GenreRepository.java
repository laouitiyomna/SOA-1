package com.yomna.genre.repos;


import com.yomna.genre.entities.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {
    Genre findByCodeGenre(String code);
}