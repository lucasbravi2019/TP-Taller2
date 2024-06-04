package com.bravi.mapper.impl;

import com.bravi.constant.MapperType;
import com.bravi.context.AppContext;
import com.bravi.mapper.XMLMapper;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapperStrategyFactory {

    private final Map<String, XMLMapper> mappers = new HashMap<>();

    public MapperStrategyFactory(AppContext appContext) {
        mappers.put(MapperType.PRODUCT.getFilename(), appContext.getProductMapperInstance());
        mappers.put(MapperType.CLIENT.getFilename(), appContext.getClientMapperInstance());
        mappers.put(MapperType.ORDER.getFilename(), appContext.getOrderMapperInstance());
    }

    public Set<String> getFilenames() {
        return mappers.keySet();
    }

    public XMLMapper getMapper(String filename) {
        return mappers.get(filename);
    }

}
