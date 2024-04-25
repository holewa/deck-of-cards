package com.doc.deckofcards.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.doc.deckofcards.service.CardService;

@Configuration
public class AppConfig {

    @Bean
    public CardService deckService() {
        return new CardService();
    }
}
