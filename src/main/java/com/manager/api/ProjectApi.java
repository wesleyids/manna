package com.manager.api;

import com.manager.domain.project.*;
import com.manager.domain.project.command.CreateProjectCommand;
import com.manager.domain.project.command.UpdateProjectCommand;
import com.manager.domain.project.query.ProjectQueryRequest;
import com.manager.domain.project.query.ProjectResponse;
import com.manager.domain.project.query.RemoveProjectRequest;
import javassist.NotFoundException;

import java.util.List;

public class ProjectApi {

    private DrivenPort drivenPort;

    public ProjectApi(DrivenPort driver) {
        this.drivenPort = driver;
    }

    public void of(CreateProjectCommand command) {
        ProjectService service = new ProjectService(drivenPort);
        service.save(command);
    }

    public void of(UpdateProjectCommand command) {
        ProjectService service = new ProjectService(drivenPort);
        service.update(command);
    }

    public ProjectResponse of(ProjectId id) throws NotFoundException {
        ProjectService service = new ProjectService(drivenPort);
        return service.get(id);
    }

    public void of(RemoveProjectRequest request) {
        ProjectService service = new ProjectService(drivenPort);
        service.remove(new ProjectId(request.getId()));
    }

    public List<ProjectResponse> of(ProjectQueryRequest request) {
        ProjectService service = new ProjectService(drivenPort);
        return service.findAll(request);
    }
}
