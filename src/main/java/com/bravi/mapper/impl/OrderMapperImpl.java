package com.bravi.mapper.impl;

import com.bravi.entity.Order;
import com.bravi.mapper.XMLMapper;
import com.bravi.repository.Repository;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class OrderMapperImpl implements XMLMapper {

    private final Repository<Order> orderRepository;

    public OrderMapperImpl(Repository<Order> orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void processElements(Document document) {
        NodeList nodes = document.getElementsByTagName("order");
        for (int i = 0; i < nodes.getLength(); i++) {
            Element orderItem = (Element) nodes.item(i);
            Integer id = Integer.valueOf(orderItem.getAttribute("id"));
            Integer clientId = Integer.valueOf(orderItem.getElementsByTagName("client-id").item(0).getTextContent());
            NodeList products = orderItem.getElementsByTagName("product");

            Order orderEntity = Order.builder()
                    .id(id)
                    .clientId(clientId)
                    .build();

            for (int j = 0; j < products.getLength(); j++) {
                Element product = (Element) products.item(j);
                Integer productId = Integer.valueOf(product.getElementsByTagName("product-id").item(0).getTextContent());
                Float quantity = Float.valueOf(product.getElementsByTagName("quantity").item(0).getTextContent());

                Order.ProductOrder productOrder = Order.ProductOrder.builder()
                        .productId(productId)
                        .quantity(quantity)
                        .build();

                orderEntity.addProduct(productOrder);
            }

            orderRepository.save(orderEntity);
        }
    }
}
