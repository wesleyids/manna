package com.manager.domain;

public abstract class QueryRequest {

    private int limit = 10;
    private int offset = 0;

    public int getLimit() {
        return limit;
    }

    public int getOffset() {
        return offset;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
