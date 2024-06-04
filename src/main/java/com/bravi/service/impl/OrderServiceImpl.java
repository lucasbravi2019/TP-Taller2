package com.bravi.service.impl;

import com.bravi.entity.Order;
import com.bravi.repository.Repository;
import com.bravi.service.OrderService;

import java.util.List;

import static com.bravi.util.Logger.log;

public class OrderServiceImpl implements OrderService {

    private final Repository<Order> orderRepository;

    public OrderServiceImpl(Repository<Order> orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void showAllOrders() {
        List<Order> orders = orderRepository.findAll();

        for (Order order : orders) {
            log("Order");
            log("Id: " + order.getId());
            log("ClientId: " + order.getClientId());

            for (Order.ProductOrder product : order.getProducts()) {
                log("Producto");
                log("ProductId: " + product.getProductId());
                log("Quantity: " + product.getQuantity());
            }
        }
    }
}
