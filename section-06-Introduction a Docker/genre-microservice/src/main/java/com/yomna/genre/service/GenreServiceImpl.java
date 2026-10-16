package com.yomna.genre.service;

import com.yomna.genre.dto.GenreDto;
import com.yomna.genre.entities.Genre;
import com.yomna.genre.repos.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenreServiceImpl implements GenreService {

    @Autowired
    GenreRepository genreRepository;

    @Override
    public GenreDto getGenreByCode(String code) {
        Genre genre = genreRepository.findByCodeGenre(code);
        GenreDto genreDto = new GenreDto(
                genre.getId(),
                genre.getNomGenre(),
                genre.getCodeGenre()
        );
        return genreDto;
    }
}