package com.begodly.springclientlogging.todo;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class TodoClient {

    private final RestClient client;

    public TodoClient(RestClient.Builder builder) {
        client = builder.baseUrl("https://jsonplaceholder.typicode.com/")
                .build();
    }

    /**
     * Uri template variable <a href="https://docs.spring.io/spring-framework/reference/integration/rest-clients.html#_request_url">spring docs - rest-clients</a>.
     */
    public String get(Integer id) {
        return client.get()

                .uri("/todos/{id}", id)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(String.class);
    }

    public String getAll() {
        return client.get()
                .uri("/todos")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(String.class);
    }
}
