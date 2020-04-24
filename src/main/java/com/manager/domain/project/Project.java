package com.manager.domain.project;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.manager.domain.project.command.CreateProjectCommand;
import com.manager.domain.project.command.UpdateProjectCommand;
import com.manager.domain.task.Task;
import com.manager.domain.vo.Created;
import com.manager.domain.vo.Description;
import com.manager.domain.vo.Name;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Project {

    @EmbeddedId
    private ProjectId id;

    @Embedded
    private Name name;

    @Embedded
    private Description description;

    private String prefix;

    @Embedded
    private Created created;

//    @OneToMany(mappedBy = "project", fetch = FetchType.LAZY)
//    @JsonManagedReference
//    private List<Task> tasks = new ArrayList<>();

    public Project() {}

    public Project(CreateProjectCommand command) {
        this.name = new Name(command.getName());
        this.description = new Description(command.getDescription());
        this.prefix = command.getPrefix();
        this.created = new Created();
    }

    public Project(UpdateProjectCommand command) {
        this.name = new Name(command.getName());
        this.description = new Description(command.getDescription());
        this.prefix = command.getPrefix();
        this.created = new Created(command.getCreated());
    }

    public ProjectId getId() {
        return id;
    }

    public Name getName() {
        return name;
    }

    public Description getDescription() {
        return description;
    }

    public String getPrefix() {
        return prefix;
    }

    public Created getCreated() {
        return created;
    }

    public void setId(ProjectId projectId) {
        this.id = projectId;
    }
}
