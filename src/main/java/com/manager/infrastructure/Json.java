package com.manager.infrastructure;

/**
 * This interface provides methods to parse Json Strings to a java object and reverse.
 *
 * @author Wesley Inacio
 *
 */
public interface Json {

    public String parse(Object value);

    public <T> T parse(String json, Class<?> classType);

}
