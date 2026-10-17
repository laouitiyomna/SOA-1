package com.yomna.genre.service;

import com.yomna.genre.dto.GenreDto;

public interface GenreService {
    GenreDto getGenreByCode(String code);
}