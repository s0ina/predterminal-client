package com.example.predterminal.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class PredTerminalClient {

    private final RestClient restClient;

    public PredTerminalClient() {
        this.restClient = RestClient.builder()
                .baseUrl("https://predterminal.com/api/public")
                .build();
    }

    public String getWhaleTrades() {
        return restClient
                .get()
                .uri("/prediction-whales?limit=1")
                .retrieve()
                .body(String.class);
    }
}
