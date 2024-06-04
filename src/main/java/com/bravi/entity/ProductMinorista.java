package com.bravi.entity;

import com.bravi.constant.ProductType;

public class ProductMinorista extends Product{

    @Override
    public boolean isMayorista() {
        return false;
    }

    public static ProductMinorista.ProductMinoristaBuilder builder() {
        return new ProductMinorista.ProductMinoristaBuilder();
    }

    public static class ProductMinoristaBuilder {
        private ProductMinorista product;

        public ProductMinoristaBuilder() {
            product = new ProductMinorista();
        }

        public ProductMinoristaBuilder id(Integer id) {
            if (id != null) {
                product.setId(id);
            }
            return this;
        }

        public ProductMinoristaBuilder description(String description) {
            if (description != null) {
                product.setDescription(description);
            }
            return this;
        }

        public ProductMinoristaBuilder brand(String brand) {
            if (brand != null) {
                product.setBrand(brand);
            }
            return this;
        }

        public ProductMinoristaBuilder productType(ProductType productType) {
            if (productType != null) {
                product.setProductType(productType);
            }
            return this;
        }

        public ProductMinoristaBuilder quantity(Float quantity) {
            if (quantity != null) {
                product.setQuantity(quantity);
            }
            return this;
        }

        public ProductMinoristaBuilder metric(String metric) {
            if (metric != null) {
                product.setMetric(metric);
            }
            return this;
        }

        public ProductMinoristaBuilder price(Double price) {
            if (price != null) {
                product.setPrice(price);
            }
            return this;
        }

        public ProductMinorista build() {
            return product;
        }

    }

}
