package com.example.predterminal.model;

import java.util.List;
import tools.jackson.databind.JsonNode;

public class WhaleTradesResponse {

    private boolean success;
    private List<JsonNode> whales;
    private int count;
    boolean isPro;
    private String timestamp;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<JsonNode> getWhales() {
        return whales;
    }

    public void setWhales(List<JsonNode> whales) {
        this.whales = whales;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean isPro() {
        return isPro;
    }

    public void setisPro(boolean isPro) {
        this.isPro = isPro;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}