package com.bravi.constant;

import com.bravi.mapper.XMLMapper;
import com.bravi.mapper.impl.ClientMapperImpl;
import com.bravi.mapper.impl.OrderMapperImpl;
import com.bravi.mapper.impl.ProductMapperImpl;

public enum MapperType {

    PRODUCT("products.xml", ProductMapperImpl.class),
    ORDER("orders.xml", OrderMapperImpl.class),
    CLIENT("clients.xml", ClientMapperImpl.class);

    private final String filename;
    private final Class<? extends XMLMapper> clazz;

    MapperType(String filename, Class<? extends XMLMapper> clazz) {
        this.filename = filename;
        this.clazz = clazz;
    }

    public String getFilename() {
        return filename;
    }

    public Class<?> getClazz() {
        return clazz;
    }
}
