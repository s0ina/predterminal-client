package com.example.predterminal;

import com.example.predterminal.client.PredTerminalClient;
import com.example.predterminal.model.WhaleTradesResponse;

import tools.jackson.core.JacksonException;
import tools.jackson.databind.ObjectMapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.predterminal.model.WhaleTrade;

@SpringBootTest
class PredTerminalClientTest {

    @Autowired
    private PredTerminalClient client;
    
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldFetchWhaleTrades() {
        WhaleTradesResponse response = client.getWhaleTrades(100);
        
        assertNotNull(response);
        assertTrue(response.isSuccess());
        assertNotNull(response.getWhales());

        System.out.println("Success: " + response.isSuccess());
        System.out.println("Whales count: " + response.getCount());
        System.out.println("Is Pro: " + response.isPro());
        System.out.println("Timestamp: " + response.getTimestamp());
        System.out.println("Whales list: " + response.getWhales());
        System.out.println("Whales list size: " + response.getWhales().size());
        
        if (response.getWhales().isEmpty()) {
            System.out.println("No whale trades found.");
        } else {
            System.out.println("Whale trades found: "
                    + response.getWhales().size());
        }
    }
    
    @Test
    void shouldRejectInvalidLimit() {
        assertThrows(IllegalArgumentException.class, () -> {
            client.getWhaleTrades(0);
        });
    }
    
    @Test
    void shouldCreateWhaleTrade() {

        WhaleTrade trade = new WhaleTrade();

        trade.setMarket("BTC");
        trade.setAmount(15000);
        trade.setPrice(67500);

        assertEquals("BTC", trade.getMarket());
        assertEquals(15000, trade.getAmount());
        assertEquals(67500, trade.getPrice());
    }
    
    @Test
    void shouldConvertJsonToWhaleTrade() throws JacksonException {

        String json = """
                {
                    "market": "BTC",
                    "amount": 15000,
                    "price": 67500
                }
                """;

        WhaleTrade trade = objectMapper.readValue(json, WhaleTrade.class);

        assertEquals("BTC", trade.getMarket());
        assertEquals(15000, trade.getAmount());
        assertEquals(67500, trade.getPrice());
    }
    
    @Test
    void shouldInjectPredTerminalClient() {
        assertNotNull(client);
    }
    
}