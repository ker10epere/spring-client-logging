package com.begodly.springclientlogging.config.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Slf4j
public class BeGodlyClientHttpRequestInterceptor implements ClientHttpRequestInterceptor {
    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        logRequest(request, body);
        ClientHttpResponse response = execution.execute(request, body);
        logResponse(response);
        return response;
    }

    private void logRequest(HttpRequest request, byte[] body) {
        log.info("Request: {} {}", request.getMethod(), request.getURI());
        log.info("Request header: {}", request.getHeaders());
        log.info("Request body: {}", new String(body, StandardCharsets.UTF_8));
    }

    private void logResponse(ClientHttpResponse response) throws IOException {
        log.info("Response status code: {}", response.getStatusCode());
        log.info("Response headers: {}", response.getHeaders());
        // this requires requestFactory to be Buffering
        // ex. RestClient.Builder.requestFactory(new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory()))
        log.info("Response body: {}", new String(response.getBody().readAllBytes(), StandardCharsets.UTF_8));
    }
}
