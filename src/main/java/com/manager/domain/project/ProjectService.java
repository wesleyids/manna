package com.manager.domain.project;

import com.manager.api.DrivenPort;
import com.manager.domain.project.command.CreateProjectCommand;
import com.manager.domain.project.command.UpdateProjectCommand;
import com.manager.domain.project.query.ProjectQueryRequest;
import com.manager.domain.project.query.ProjectResponse;
import javassist.NotFoundException;

import java.util.List;

public class ProjectService {

    private DrivenPort drivenPort;

    public ProjectService() {}

    public ProjectService(DrivenPort drivenPort) {
        this.drivenPort = drivenPort;
    }

    public void save(CreateProjectCommand command) {
        drivenPort.projectRepository().save(new Project(command));
    }

    public void update(UpdateProjectCommand command) {
        drivenPort.projectRepository().update(new Project(command));
    }

    public ProjectResponse get(ProjectId projectId) throws NotFoundException {
        Project project = drivenPort.projectRepository().get(projectId);
        return new ProjectResponse(project);
    }

    public void remove(ProjectId projectId) {
        drivenPort.projectRepository().remove(projectId);
    }

    public List<ProjectResponse> findAll(ProjectQueryRequest request) {
        List<Project> projects = drivenPort.projectRepository().findAll(request);
        return ProjectResponse.of(projects);
    }

}
