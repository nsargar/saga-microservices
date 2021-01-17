package com.poc.r2dbc.demo.handler;

import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

public interface ProductHandler {

    Mono<ServerResponse> saveProduct(ServerRequest request);

    Mono<ServerResponse> getProductById(ServerRequest request);
}
