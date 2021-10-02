package com.typicode.jsonplaceholder.helpers;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RequestHelpers {

    private static final HttpClient httpClient = HttpClient.newBuilder().build();
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com";

    public static HttpResponse<String> sendGetRequestTo(String endpoint) {
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(BASE_URL + endpoint))
                .build();
        try {
            return httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }

}