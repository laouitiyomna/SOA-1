package com.yomna.evenement.functions;

import com.yomna.evenement.service.EvenementService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
public class EvenementFunctions {
    private static final Logger log = LoggerFactory.getLogger(EvenementFunctions.class);

    @Bean
    public Consumer<Long> updateCommunication(EvenementService evenementService) {
        return evenementId -> {
            log.info("Updating Communication status for the evenement Id : " + evenementId);
            evenementService.updateCommunicationStatus(evenementId);
        };
    }
}