package com.yomna.evenement.service;

import com.yomna.evenement.dto.EvenementDto;

public interface EvenementService {
    EvenementDto getEvenementById(Long id);
}