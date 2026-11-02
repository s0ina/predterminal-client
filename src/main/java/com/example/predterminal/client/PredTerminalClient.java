package com.example.predterminal.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientResponseException;

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
		
		if (limit < 1) {
	        throw new IllegalArgumentException(
	                "Limit must be greater than 0"
	        );
	    }
		try {
			return restClient
					.get()
					.uri(uriBuilder -> uriBuilder
							.path("/prediction-whales")
							.queryParam("limit", limit)
							.build())
					.retrieve()
					.body(WhaleTradesResponse.class);

		} catch (RestClientResponseException e) {
			System.out.println("API error: " + e.getStatusCode());
			throw e;
		}
	}
}
