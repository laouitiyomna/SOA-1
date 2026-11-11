
package com.yomna.message.functions;

import com.yomna.message.dto.EvenementMessageDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class MessageFunctions {

    private static final Logger log =
            LoggerFactory.getLogger(MessageFunctions.class);

    @Bean
    public Function<EvenementMessageDto, EvenementMessageDto> email() {
        return dto -> {
            log.info("Sending email with the details: " + dto.toString());
            return dto;
        };
    }

    @Bean
    public Function<EvenementMessageDto, Long> sms() {
        return dto -> {
            log.info("Sending sms with the details: " + dto.toString());
            return dto.evenementId();
        };
    }
}
