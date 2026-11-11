package com.yomna.evenement.restControllers;

import com.yomna.evenement.config.Configuration;
import com.yomna.evenement.dto.APIResponseDto;
import com.yomna.evenement.dto.EvenementDto;
import com.yomna.evenement.service.EvenementService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/evenements")
@AllArgsConstructor
public class EvenementController {

    private EvenementService evenementService;
    private Configuration configuration;

    @GetMapping("/{id}")
    public ResponseEntity<APIResponseDto> getEvenementById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(evenementService.getEvenementById(id));
    }

    @GetMapping("/author")
    public ResponseEntity<String> retrieveAuthorInfo() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(configuration.getName() + " " + configuration.getEmail());
    }
    @PostMapping("/create")
    public ResponseEntity<String> createEvenement(@RequestBody EvenementDto evenementDto) {
        evenementService.createEvenement(evenementDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Evenement created successfully");
    }
}