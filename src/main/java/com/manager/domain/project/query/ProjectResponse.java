package com.manager.domain.project.query;

import com.manager.domain.project.Project;

import java.util.ArrayList;
import java.util.List;

public class ProjectResponse {

    private Long id;
    private String name;
    private String description;
    private String prefix;

    public ProjectResponse(Project project) {
        this.id = project.getId().get();
        this.name = project.getName().get();
        this.description = project.getDescription().get();
        this.prefix = project.getPrefix();
    }

    public static List<ProjectResponse> of(List<Project> projects) {
        List<ProjectResponse> result = new ArrayList<>();
        for (Project project : projects) {
            result.add(new ProjectResponse(project));
        }
        return result;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getPrefix() {
        return prefix;
    }
}
