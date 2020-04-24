package com.manager.infrastructure.impl;

import com.google.gson.Gson;
import com.manager.infrastructure.Json;

/**
 * Implementation of the {@link Json} interface.
 *
 * @author Wesley Inacio
 *
 */
public class JsonImpl implements Json {

    @Override
    public String parse(Object value) {
        return new Gson().toJson(value);
    }

    @Override
    public <T> T parse(String json, Class<?> classType) {
        return (T) new Gson().fromJson(json.toString(), classType);
    }
}
