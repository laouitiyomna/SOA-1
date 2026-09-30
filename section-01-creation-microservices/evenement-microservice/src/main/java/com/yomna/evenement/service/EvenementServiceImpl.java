package com.yomna.evenement.service;

import com.yomna.evenement.dto.EvenementDto;
import com.yomna.evenement.entities.Evenement;
import com.yomna.evenement.repos.EvenementRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class EvenementServiceImpl implements EvenementService {

    private EvenementRepository evenementRepository;

    @Override
    public EvenementDto getEvenementById(Long id) {
        Evenement evenement = evenementRepository.findById(id).get();
        return new EvenementDto(
                evenement.getIdEvenement(),
                evenement.getNomEvenement(),
                evenement.getLieu(),
                evenement.getDateEvenement(),
                evenement.getOrganisateur(),
                evenement.getEmail()
        );
    }
}