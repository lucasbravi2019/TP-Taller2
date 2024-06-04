package com.bravi.repository;

import com.bravi.entity.Entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Repository<T extends Entity> {

    private final Map<Integer, T> entities = new HashMap<>();

    public void save(T entity) {
        if (entity != null)
            entities.put(entity.getId(), entity);
    }

    public void deleteById(Integer id) {
        if (id != null)
            entities.remove(id);
    }

    public T findById(Integer id) {
        return entities.get(id);
    }

    public List<T> findAll() {
        return new ArrayList<>(entities.values());
    }

}
