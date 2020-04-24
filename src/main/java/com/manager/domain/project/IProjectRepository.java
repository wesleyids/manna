package com.manager.domain.project;

import com.manager.domain.project.query.ProjectQueryRequest;
import javassist.NotFoundException;

import java.util.List;

public interface IProjectRepository {

    public Project save(Project project);

    public void update(Project project);

    public Project get(ProjectId projectId) throws NotFoundException;

    public void remove(ProjectId projectId);

    public List<Project> findAll(ProjectQueryRequest request);

}
