package com.devz.photoapp.api.gateway;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;

@Component
public class AuthorizationHeaderFilter extends AbstractGatewayFilterFactory<AuthorizationHeaderFilter.config> {

    @Override
    public GatewayFilter apply(config config) {
        return null;
    }

    public static class config{

    }
}
