package com.bravi.entity;

import java.util.ArrayList;
import java.util.List;

public abstract class Client extends Entity {

    private Integer id;
    private String name;
    private String direccion;
    private List<Order> orders = new ArrayList<>();

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void addOrder(Order order) {
        if (order != null)
            this.orders.add(order);
    }

    public void removeOrder(Order order) {
        if (order != null)
            this.orders.removeIf(originalOrder -> originalOrder.getId().equals(order.getId()));
    }

    public abstract boolean isMayorista();

}
