package com.example.name;

public class ErrorResponse {
    private final String timestamp;
    private final int status;
    private final String error;
    private final String message;
    private final String path;

    public ErrorResponse(String timestamp, int status, String error, String message, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public int getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    public String getPath() {
        return path;
    }
}
<<<<<<< HEAD
=======

>>>>>>> 1c97a1300676b342a4fce1b06f0d3e4ac5025703
