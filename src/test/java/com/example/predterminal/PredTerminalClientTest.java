package com.example.predterminal;

import com.example.predterminal.client.PredTerminalClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PredTerminalClientTest {

    @Autowired
    private PredTerminalClient client;

    @Test
    void shouldFetchWhaleTrades() {
        String response = client.getWhaleTrades();

        System.out.println(response);
    }
}