package com.yomna.evenement.service;

import com.yomna.evenement.dto.APIResponseDto;
import com.yomna.evenement.dto.EvenementDto;

public interface EvenementService {
    APIResponseDto getEvenementById(Long id);
    void createEvenement(EvenementDto evenementDto);
    boolean updateCommunicationStatus(Long evenementId);
}