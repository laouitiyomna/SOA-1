package com.yomna.evenement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EvenementDto {
    private Long idEvenement;
    private String nomEvenement;
    private String lieu;
    private LocalDate dateEvenement;
    private String organisateur;
    private String email;
}