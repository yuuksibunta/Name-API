package com.example.name;

import java.util.HashMap;
import java.util.Map;

public class NameResponse {
    private final Map<String, String> response;

    public NameResponse(String message) {
        this.response = new HashMap<>();
        this.response.put("message", message);
    }

    public Map<String, String> getResponse() {
        return response;
    }
}
