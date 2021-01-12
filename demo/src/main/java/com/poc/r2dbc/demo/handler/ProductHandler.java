package com.poc.r2dbc.demo.handler;

import com.poc.r2dbc.demo.domain.Product;
import com.poc.r2dbc.demo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.reactive.function.BodyExtractors;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class ProductHandler {

    private final ProductService productService;

    Mono<ServerResponse> saveProduct(ServerRequest request){
        return null
                ;
    }
}
