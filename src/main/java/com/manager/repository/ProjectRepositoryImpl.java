package com.manager.repository;

import com.manager.domain.project.IProjectRepository;
import com.manager.domain.project.Project;
import com.manager.domain.project.ProjectId;
import com.manager.domain.project.query.ProjectQueryRequest;
import com.manager.domain.project.query.ProjectResponse;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectRepositoryImpl implements IProjectRepository {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public Project save(Project project) {
        Long id = projectRepository.nextId();
        project.setId(new ProjectId(id == null ? 1L : id));
        return this.projectRepository.save(project);
    }

    @Override
    public void update(Project project) {
        this.projectRepository.save(project);
    }

    @Override
    public Project get(ProjectId projectId) throws NotFoundException {
        Optional<Project> project = this.projectRepository.findById(projectId);
        if (!project.isPresent()) {
            throw new NotFoundException("Not found project");
        }
        return project.get();
    }

    @Override
    public void remove(ProjectId projectId) {
        this.projectRepository.deleteById(projectId);
    }

    @Override
    public List<Project> findAll(ProjectQueryRequest request) {
        return this.projectRepository.findAll();
    }
}
