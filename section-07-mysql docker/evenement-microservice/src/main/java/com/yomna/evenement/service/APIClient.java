package com.yomna.evenement.service;

import com.yomna.evenement.dto.GenreDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(url = "http://localhost:8080", value = "GENRE")
@FeignClient(name = "GENRE")
public interface APIClient {

    @GetMapping("api/genres/{genre-code}")
    GenreDto getGenreByCode(@PathVariable("genre-code") String genreCode);
}