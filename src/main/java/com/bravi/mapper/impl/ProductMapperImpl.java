package com.bravi.mapper.impl;

import com.bravi.constant.ProductType;
import com.bravi.entity.Product;
import com.bravi.entity.ProductMayorista;
import com.bravi.entity.ProductMinorista;
import com.bravi.mapper.XMLMapper;
import com.bravi.repository.Repository;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class ProductMapperImpl implements XMLMapper {

    private final Repository<Product> productRepository;

    public ProductMapperImpl(Repository<Product> productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void processElements(Document document) {
        NodeList nodes = document.getElementsByTagName("product");
        for (int i = 0; i < nodes.getLength(); i++) {
            Element product = (Element) nodes.item(i);
            Integer id = Integer.valueOf(product.getAttribute("id"));
            String description = product.getElementsByTagName("description").item(0).getTextContent();
            String brand = product.getElementsByTagName("brand").item(0).getTextContent();
            String productType = product.getElementsByTagName("product-type").item(0).getTextContent();
            Float quantity = Float.valueOf(product.getElementsByTagName("quantity").item(0).getTextContent());
            String metric = product.getElementsByTagName("metric").item(0).getTextContent();
            Double price = Double.valueOf(product.getElementsByTagName("price").item(0).getTextContent());
            Boolean mayorista = Boolean.valueOf(product.getElementsByTagName("mayorista").item(0).getTextContent());

            Product productEntity;

            if (Boolean.TRUE.equals(mayorista)) {
                Integer minQuantity = Integer.valueOf(product.getElementsByTagName("min-quantity").item(0).getTextContent());

                productEntity = ProductMayorista.builder()
                        .id(id)
                        .description(description)
                        .brand(brand)
                        .productType(ProductType.getProductTypeByType(productType))
                        .quantity(quantity)
                        .metric(metric)
                        .price(price)
                        .minQuantity(minQuantity)
                        .build();
            } else {
                productEntity = ProductMinorista.builder()
                        .id(id)
                        .description(description)
                        .brand(brand)
                        .productType(ProductType.getProductTypeByType(productType))
                        .quantity(quantity)
                        .metric(metric)
                        .price(price)
                        .build();
            }

            productRepository.save(productEntity);
        }
    }
}

