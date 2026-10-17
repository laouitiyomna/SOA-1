package com.yomna.evenement.service;

import com.yomna.evenement.dto.APIResponseDto;
import com.yomna.evenement.dto.EvenementDto;
import com.yomna.evenement.dto.GenreDto;
import com.yomna.evenement.entities.Evenement;
import com.yomna.evenement.repos.EvenementRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EvenementServiceImpl implements EvenementService {

    private EvenementRepository evenementRepository;
    private APIClient apiClient;

    @Override
    public APIResponseDto getEvenementById(Long id) {
        Evenement evenement = evenementRepository.findById(id).get();

        GenreDto genreDto = apiClient.getGenreByCode(evenement.getCodeGenre());

        EvenementDto evenementDto = new EvenementDto(
                evenement.getIdEvenement(),
                evenement.getNomEvenement(),
                evenement.getLieu(),
                evenement.getDateEvenement(),
                evenement.getOrganisateur(),
                evenement.getEmail(),
                evenement.getCodeGenre(),
                genreDto.getNomGenre()
        );

        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEvenementDto(evenementDto);
        apiResponseDto.setGenreDto(genreDto);

        return apiResponseDto;
    }
}
