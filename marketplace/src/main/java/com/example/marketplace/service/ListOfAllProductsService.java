package com.example.marketplace.service;

import com.example.marketplace.repository.ProductsRepository;
import com.example.marketplace.domain.Products;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ListOfAllProductsService {
    ProductsRepository productsRepository;

    public ListOfAllProductsService(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;

    }

    public Page<Products> findAll(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<Products> products = productsRepository.findAll(pageable);
        products.getTotalElements();
        products.getTotalPages();

        return products;
    }

}