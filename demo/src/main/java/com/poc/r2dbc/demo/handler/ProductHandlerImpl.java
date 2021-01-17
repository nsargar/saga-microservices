package com.poc.r2dbc.demo.handler;

import com.poc.r2dbc.demo.domain.Product;
import com.poc.r2dbc.demo.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Component
public class ProductHandlerImpl implements ProductHandler {

    private final ProductRepository productRepository;


    @Override
    public Mono<ServerResponse> saveProduct(ServerRequest request) {

        Mono<Product> savedProduct = request
                .bodyToMono(Product.class)
                .flatMap(productRepository::save);

        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(savedProduct, Product.class);
    }

    @Override
    public Mono<ServerResponse> getProductById(ServerRequest request) {

        Mono<Product> returnedProduct = productRepository.findById(Long.valueOf(request.pathVariable("id")));

        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(returnedProduct, Product.class);
    }
}
