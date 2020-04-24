package com.manager.domain.project.query;

import com.manager.domain.QueryRequest;

public class ProjectQueryRequest extends QueryRequest {

    private Long userId;
    private String name;
    private String description;

    public ProjectQueryRequest(int limit) {
        setLimit(limit);
    }

    public ProjectQueryRequest() {}

    public ProjectQueryRequest(Long userId, String name, String description) {
        this.userId = userId;
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Long getUserId() {
        return userId;
    }
}
