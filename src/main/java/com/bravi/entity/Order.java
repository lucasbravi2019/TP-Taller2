package com.bravi.entity;

import java.util.ArrayList;
import java.util.List;

public class Order extends Entity {

    private Integer id;
    private Integer clientId;
    private List<ProductOrder> products =  new ArrayList<>();


    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public List<ProductOrder> getProducts() {
        return products;
    }

    public void addProduct(ProductOrder product) {
        if (product != null)
            this.products.add(product);
    }

    public static OrderBuilder builder() {
        return new OrderBuilder();
    }

    public static class OrderBuilder {
        private Order order;

        public OrderBuilder() {
            order = new Order();
        }

        public OrderBuilder id(Integer id) {
            if (id != null) {
                order.setId(id);
            }
            return this;
        }

        public OrderBuilder clientId(Integer clientId) {
            if (clientId != null) {
                order.setClientId(clientId);
            }
            return this;
        }

        public Order build() {
            return order;
        }

    }

    public static class ProductOrder {
        private Integer productId;
        private Float quantity;

        public Integer getProductId() {
            return productId;
        }

        public void setProductId(Integer productId) {
            this.productId = productId;
        }

        public Float getQuantity() {
            return quantity;
        }

        public void setQuantity(Float quantity) {
            this.quantity = quantity;
        }

        public static ProductOrderBuilder builder() {
            return new ProductOrderBuilder();
        }

        public static class ProductOrderBuilder {
            private ProductOrder productOrder;

            public ProductOrderBuilder() {
                productOrder = new ProductOrder();
            }

            public ProductOrderBuilder productId(Integer productId) {
                if (productId != null) {
                    productOrder.setProductId(productId);
                }
                return this;
            }

            public ProductOrderBuilder quantity(Float quantity) {
                if (quantity != null) {
                    productOrder.setQuantity(quantity);
                }
                return this;
            }

            public ProductOrder build() {
                return productOrder;
            }
        }
    }
}
