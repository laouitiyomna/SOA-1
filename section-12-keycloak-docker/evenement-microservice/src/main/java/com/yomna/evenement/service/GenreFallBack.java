package com.yomna.evenement.service;

import com.yomna.evenement.dto.GenreDto;
import org.springframework.stereotype.Component;

@Component
public class GenreFallBack implements APIClient {
    @Override
    public GenreDto getGenreByCode(String genreCode) {
        return null;
    }
}