package com.begodly.springclientlogging.config.client;

import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class BeGodlyRestClientBuilderImpl implements BeGodlyRestClientBuilder {
    /**
     * Refer to {@link BeGodlyClientHttpRequestInterceptor#logResponse(ClientHttpResponse)} for comments
     *
     * @param builder
     * @return
     */
    @Override
    public RestClient.Builder apply(RestClient.Builder builder) {
        return builder
                .requestFactory(new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory()))
                .requestInterceptor(new BeGodlyClientHttpRequestInterceptor());
    }
}
