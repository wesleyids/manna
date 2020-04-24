package com.manager.business;

import com.manager.domain.project.ProjectId;
import com.manager.domain.project.command.CreateProjectCommand;
import com.manager.domain.project.command.UpdateProjectCommand;
import com.manager.domain.project.query.ProjectQueryRequest;
import com.manager.domain.project.query.ProjectResponse;
import com.manager.domain.project.query.RemoveProjectRequest;
import com.manager.infrastructure.config.ApiConfig;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectBusiness {

    @Autowired
    private ApiConfig apiConfig;

    public void save(CreateProjectCommand command) {
        apiConfig.projectApi().of(command);
    }

    public void update(UpdateProjectCommand command) {
        apiConfig.projectApi().of(command);
    }

    public ProjectResponse find(ProjectId projectId) throws NotFoundException {
        return apiConfig.projectApi().of(projectId);
    }

    public void remove(RemoveProjectRequest request) {
        apiConfig.projectApi().of(request);
    }

    public List<ProjectResponse> findAll(ProjectQueryRequest request) {
        return apiConfig.projectApi().of(request);
    }

}
