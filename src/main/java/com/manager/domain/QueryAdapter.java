package com.manager.domain;

/**
 * This class provides methods to create and retrieve data in memory, but we can use QueryAdapter with database
 *
 * @author Wesley Inacio
 *
 */
public interface QueryAdapter {

    public String put(String key, Object value);

    public <T> T get(String key, Class<T> clazz);

    public <T> T get(Long key, Class<T> clazz);

    public String update(String key, Object value);

    public String remove(String key);

}
