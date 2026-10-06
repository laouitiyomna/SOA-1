package com.yomna.genre.restControllers;

import com.yomna.genre.config.Configuration;
import com.yomna.genre.dto.GenreDto;
import com.yomna.genre.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/genres")
public class GenreController {

    @Autowired
    private GenreService genreService;

    @Value("${build.version}")
    private String buildVersion;

    @GetMapping("/{code}")
    public ResponseEntity<GenreDto> getGenreByCode(@PathVariable("code") String code) {
        return ResponseEntity.ok(genreService.getGenreByCode(code));
    }

    @GetMapping("/version")
    public ResponseEntity<String> version() {
        return ResponseEntity.status(HttpStatus.OK).body(buildVersion);
    }

    @Autowired
    Configuration configuration;

    @GetMapping("/author")
    public ResponseEntity<String> retrieveAuthorInfo() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(configuration.getName() + " " + configuration.getEmail());
    }
}