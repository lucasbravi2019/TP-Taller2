package com.bravi.service.impl;

import com.bravi.entity.Product;
import com.bravi.repository.Repository;
import com.bravi.service.ProductService;
import com.bravi.util.Logger;

import java.util.List;

import static com.bravi.util.Logger.*;

public class ProductServiceImpl implements ProductService {

    private final Repository<Product> productRepository;

    public ProductServiceImpl(Repository<Product> productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void showAllProducts() {
        List<Product> products = productRepository.findAll();

        for (Product product : products) {
            log("Product");
            log("Id: " + product.getId());
            log("Description: " + product.getDescription());
            log("Brand: " + product.getBrand());
            log("ProductType: " + product.getProductType().getType());
            log("Quantity: " + product.getQuantity());
            log("Metric: " + product.getMetric());
            log("Price: " + product.getPrice());
            log("Mayorista: " + (product.isMayorista() ? "Si" : "No"));
        }
    }


}

