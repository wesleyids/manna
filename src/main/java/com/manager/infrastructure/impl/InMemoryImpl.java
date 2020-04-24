package com.manager.infrastructure.impl;

import com.manager.domain.QueryAdapter;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Implementation of the {@link QueryAdapter} interface.
 *
 * @author Wesley Inacio
 *
 */
@Service
public class InMemoryImpl implements QueryAdapter {

    private Map<String, Object> data = new HashMap<>();

    @Override
    public String put(String key, Object value) {
        if (key == null || value == null) {
            return "nok";
        }

        String json = new JsonImpl().parse(value);

        data.put(key, json);

        return "ok";
    }

    @Override
    public <T> T get(String key, Class<T> clazz) {
        if (key == null) {
            return null;
        }

        Object object = data.get(key);

        if (object == null) {
            return null;
        }

        return new JsonImpl().parse(object.toString(), clazz);
    }

    @Override
    public <T> T get(Long key, Class<T> clazz) {
        if (key == null) {
            return null;
        }

        return get(key.toString(), clazz);
    }

    @Override
    public String update(String key, Object value) {
        if (key == null) {
            return "nok";
        }

        Object object = data.get(key);

        if (object == null) {
            return "nok";
        }

        String wasRemoved = this.remove(key);

        if (wasRemoved == "nok") {
            return "nok";
        }

        return this.put(key, value);
    }

    @Override
    public String remove(String key) {
        if (data.get(key) == null) {
            return "nok";
        }
        data.remove(key);
        return "ok";
    }
}
