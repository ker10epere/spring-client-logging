package com.begodly.springclientlogging.config.client;

import org.springframework.web.client.RestClient;

public interface BeGodlyRestClientBuilder {
    RestClient.Builder apply(RestClient.Builder builder);
}
