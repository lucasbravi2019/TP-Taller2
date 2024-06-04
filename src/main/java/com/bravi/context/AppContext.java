package com.bravi.context;

import com.bravi.entity.Client;
import com.bravi.entity.Order;
import com.bravi.entity.Product;
import com.bravi.mapper.XMLMapper;
import com.bravi.mapper.impl.ClientMapperImpl;
import com.bravi.mapper.impl.MapperStrategyFactory;
import com.bravi.mapper.impl.OrderMapperImpl;
import com.bravi.mapper.impl.ProductMapperImpl;
import com.bravi.repository.ClientRepositoryImpl;
import com.bravi.repository.OrderRepositoryImpl;
import com.bravi.repository.ProductRepositoryImpl;
import com.bravi.repository.Repository;
import com.bravi.service.ClientService;
import com.bravi.service.OrderService;
import com.bravi.service.ProductService;
import com.bravi.service.impl.ClientServiceImpl;
import com.bravi.service.impl.OrderServiceImpl;
import com.bravi.service.impl.ProductServiceImpl;

public class AppContext {

    private Repository<Client> clientRepository;
    private Repository<Product> productRepository;
    private Repository<Order> orderRepository;

    private XMLMapper clientMapper;
    private XMLMapper productMapper;
    private XMLMapper orderMapper;

    private ClientService clientService;
    private ProductService productService;
    private OrderService orderService;

    private MapperStrategyFactory mapperStrategyFactory;
    private XMLDataLoader xmlDataLoader;

    private Repository<Client> getClientRepositoryInstance() {
        if (clientRepository == null)
            clientRepository = new ClientRepositoryImpl();

        return clientRepository;
    }

    private Repository<Product> getProductRepositoryInstance() {
        if (productRepository == null)
            productRepository = new ProductRepositoryImpl();

        return productRepository;
    }

    private Repository<Order> getOrderRepositoryInstance() {
        if (orderRepository == null)
            orderRepository = new OrderRepositoryImpl();

        return orderRepository;
    }

    public XMLMapper getClientMapperInstance() {
        if (clientMapper == null)
            clientMapper = new ClientMapperImpl(getClientRepositoryInstance());

        return clientMapper;
    }

    public XMLMapper getProductMapperInstance() {
        if (productMapper == null)
            productMapper = new ProductMapperImpl(getProductRepositoryInstance());

        return productMapper;
    }

    public XMLMapper getOrderMapperInstance() {
        if (orderMapper == null)
            orderMapper = new OrderMapperImpl(getOrderRepositoryInstance());

        return orderMapper;
    }

    public ClientService getClientServiceInstance() {
        if (clientService == null)
            clientService = new ClientServiceImpl(getClientRepositoryInstance());

        return clientService;
    }

    public ProductService getProductServiceInstance() {
        if (productService == null)
            productService = new ProductServiceImpl(getProductRepositoryInstance());

        return productService;
    }

    public OrderService getOrderServiceInstance() {
        if (orderService == null)
            orderService = new OrderServiceImpl(getOrderRepositoryInstance());

        return orderService;
    }

    public MapperStrategyFactory getMapperStrategyFactory() {
        if (mapperStrategyFactory == null)
            mapperStrategyFactory = new MapperStrategyFactory(this);

        return mapperStrategyFactory;
    }

    public XMLDataLoader getXmlDataLoader() {
        if (xmlDataLoader == null)
            xmlDataLoader = new XMLDataLoader(this);

        return xmlDataLoader;
    }
}
