package com.example.predterminal;

import com.example.predterminal.client.PredTerminalClient;
import com.example.predterminal.model.WhaleTradesResponse;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PredTerminalClientTest {

    @Autowired
    private PredTerminalClient client;

    @Test
    void shouldFetchWhaleTrades() {
        WhaleTradesResponse response = client.getWhaleTrades();
        
        assertNotNull(response);
        assertTrue(response.isSuccess());
        assertNotNull(response.getWhales());

        System.out.println("Success: " + response.isSuccess());
        System.out.println("Whales count: " + response.getCount());
        System.out.println("Is Pro: " + response.isPro());
        System.out.println("Timestamp: " + response.getTimestamp());
        System.out.println("Whales list: " + response.getWhales());
        System.out.println("Whales list size: " + response.getWhales().size());
    }
}