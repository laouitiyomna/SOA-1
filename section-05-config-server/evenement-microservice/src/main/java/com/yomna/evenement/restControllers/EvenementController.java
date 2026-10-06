package com.yomna.evenement.restControllers;

import com.yomna.evenement.dto.APIResponseDto;
import com.yomna.evenement.service.EvenementService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/evenements")
@AllArgsConstructor
public class EvenementController {

    private EvenementService evenementService;

    @GetMapping("{id}")
    public ResponseEntity<APIResponseDto> getEvenementById(@PathVariable("id") Long id) {
        return new ResponseEntity<APIResponseDto>(evenementService.getEvenementById(id), HttpStatus.OK);
    }
}
