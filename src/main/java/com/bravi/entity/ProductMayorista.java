package com.bravi.entity;

import com.bravi.constant.ProductType;

public class ProductMayorista extends Product {

    private Integer minQuantity;

    public Integer getMinQuantity() {
        return minQuantity;
    }

    public void setMinQuantity(Integer minQuantity) {
        this.minQuantity = minQuantity;
    }

    @Override
    public Double getPrice() {
        return super.getPrice() * 0.9;
    }

    @Override
    public boolean isMayorista() {
        return true;
    }

    public static ProductMayoristaBuilder builder() {
        return new ProductMayoristaBuilder();
    }

    public static class ProductMayoristaBuilder {
        private ProductMayorista product;

        public ProductMayoristaBuilder() {
            product = new ProductMayorista();
        }

        public ProductMayoristaBuilder id(Integer id) {
            if (id != null) {
                product.setId(id);
            }
            return this;
        }

        public ProductMayoristaBuilder description(String description) {
            if (description != null) {
                product.setDescription(description);
            }
            return this;
        }

        public ProductMayoristaBuilder brand(String brand) {
            if (brand != null) {
                product.setBrand(brand);
            }
            return this;
        }

        public ProductMayoristaBuilder minQuantity(Integer minQuantity) {
            if (minQuantity != null) {
                product.setMinQuantity(minQuantity);
            }
            return this;
        }

        public ProductMayoristaBuilder productType(ProductType productType) {
            if (productType != null) {
                product.setProductType(productType);
            }
            return this;
        }

        public ProductMayoristaBuilder quantity(Float quantity) {
            if (quantity != null) {
                product.setQuantity(quantity);
            }
            return this;
        }

        public ProductMayoristaBuilder metric(String metric) {
            if (metric != null) {
                product.setMetric(metric);
            }
            return this;
        }

        public ProductMayoristaBuilder price(Double price) {
            if (price != null) {
                product.setPrice(price);
            }
            return this;
        }

        public ProductMayorista build() {
            return product;
        }

    }
}
