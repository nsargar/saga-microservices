package com.poc.r2dbc.demo.controller;

import com.poc.r2dbc.demo.domain.Product;
import com.poc.r2dbc.demo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Mono<Product> saveProduct(@RequestBody Product product){
        return productService.saveProduct(product);
    }
}
