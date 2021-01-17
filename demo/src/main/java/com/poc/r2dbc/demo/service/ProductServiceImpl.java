package com.poc.r2dbc.demo.service;

import com.poc.r2dbc.demo.repository.ProductRepository;
import com.poc.r2dbc.demo.domain.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {


    private final ProductRepository productRepository;

    @Override
    public Mono<Product> saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Mono<Product> getProductById(Long productId) {
        return productRepository.findById(productId);
    }
}
