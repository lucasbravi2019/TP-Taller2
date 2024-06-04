package com.bravi.constant;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum ProductType {

    COMESTIBLE("Comestible"),
    BEBIDA("Bebida");

    private static final Map<String, ProductType> enumsByType = new HashMap<>();

    static {
        EnumSet.allOf(ProductType.class).forEach(e -> enumsByType.put(e.getType(), e));
    }

    private final String type;

    ProductType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public static ProductType getProductTypeByType(String type) {
        return enumsByType.get(type);
    }
}
