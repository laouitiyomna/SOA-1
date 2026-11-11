
package com.yomna.evenement.service;

import com.yomna.evenement.dto.APIResponseDto;
import com.yomna.evenement.dto.EvenementDto;
import com.yomna.evenement.dto.EvenementMessageDto;
import com.yomna.evenement.dto.GenreDto;
import com.yomna.evenement.entities.Evenement;
import com.yomna.evenement.exceptions.ResourceNotFoundException;
import com.yomna.evenement.repos.EvenementRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.function.StreamBridge;
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

        String nomGenre;
        if (genreDto == null)
            nomGenre = "NOT AVAILABLE";
        else
            nomGenre = genreDto.getNomGenre();

        EvenementDto evenementDto = new EvenementDto(
                evenement.getIdEvenement(),
                evenement.getNomEvenement(),
                evenement.getLieu(),
                evenement.getDateEvenement(),
                evenement.getOrganisateur(),
                evenement.getEmail(),
                evenement.getCodeGenre(),
                nomGenre,
                evenement.getMobileNumber()
        );

        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEvenementDto(evenementDto);
        apiResponseDto.setGenreDto(genreDto);

        return apiResponseDto;
    }
    private static final Logger log = LoggerFactory.getLogger(EvenementServiceImpl.class);
    private final StreamBridge streamBridge;   // injecté par @AllArgsConstructor / @RequiredArgsConstructor

    @Override
    public void createEvenement(EvenementDto dto) {
        Evenement saved = evenementRepository.save(Evenement.builder()
                .nomEvenement(dto.getNomEvenement())
                .lieu(dto.getLieu())
                .dateEvenement(dto.getDateEvenement())
                .organisateur(dto.getOrganisateur())
                .codeGenre(dto.getCodeGenre())
                .email(dto.getEmail())
                .mobileNumber(dto.getMobileNumber())
                .build());
        sendCommunication(saved);
    }

    private void sendCommunication(Evenement evenement) {
        var msgDto = new EvenementMessageDto(evenement.getIdEvenement(),
                evenement.getEmail(), evenement.getMobileNumber());
        log.info("Sending Communication request for the details: {}", msgDto);
        var result = streamBridge.send("sendCommunication-out-0", msgDto);
        log.info("Is the Communication request successfully triggered ? : {}", result);
    }

    @Override
    public boolean updateCommunicationStatus(Long evenementId) {
        boolean isUpdated = false;
        if (evenementId != null) {
            Evenement evenement = evenementRepository.findById(evenementId).orElseThrow(
                    () -> new ResourceNotFoundException("Evenement", "EvenementId", evenementId.toString()));
            evenement.setCommunicationDone(true);
            evenementRepository.save(evenement);
            isUpdated = true;
        }
        return isUpdated;
    }
}
