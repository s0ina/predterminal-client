package com.example.predterminal.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import com.example.predterminal.model.WhaleTradesResponse;

@Component
public class PredTerminalClient {

    private final RestClient restClient;

    public PredTerminalClient() {
        this.restClient = RestClient.builder()
                .baseUrl("https://predterminal.com/api/public")
                .build();
    }

    public WhaleTradesResponse getWhaleTrades(int limit) {
    	return restClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path("/prediction-whales")
                        .queryParam("limit", limit)
                        .build())
                .retrieve()
                .body(WhaleTradesResponse.class);
    }
}
