package com.begodly.springclientlogging.config;

import com.begodly.springclientlogging.config.client.BeGodlyRestClientBuilder;
import org.springframework.boot.web.client.RestClientCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClientConfig {

    /**
     * to allow only single customizer, and be overridden by specific instance of
     * {@link BeGodlyRestClientBuilder}
     */
    @Bean
    RestClientCustomizer clientCustomizer(BeGodlyRestClientBuilder builder) {
        return builder::apply;
    }
}
