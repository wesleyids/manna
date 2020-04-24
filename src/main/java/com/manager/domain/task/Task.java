package com.manager.domain.task;

import com.manager.domain.TaskStatusEnum;
import com.manager.domain.user.UserId;
import com.manager.domain.project.ProjectId;
import com.manager.domain.task.command.CreateTaskCommand;
import com.manager.domain.vo.*;

import javax.persistence.*;

@Entity
public class Task {

    @EmbeddedId
    private TaskId id;

    @Embedded
    private Title title;

    @Embedded
    private Description description;

    @Embedded
    private Created created;

    @Embedded
    private Started started;

    @Embedded
    private Finished finished;

    private TaskStatusEnum status;

    @Embedded
    @AttributeOverride(name = "id", column = @Column(name = "project_id"))
    private ProjectId projectId;

    @Embedded
    @AttributeOverride(name = "id", column = @Column(name = "assignee_id"))
    private UserId userId;

    public Task() {
    }

    public Task(CreateTaskCommand command) {
        this.title = new Title(command.getTitle());
        this.description = new Description(command.getDescription());
        this.created = new Created();
        this.status = TaskStatusEnum.TODO;
        this.projectId = new ProjectId(command.getProjectId());
    }

    public void setId(TaskId id) {
        this.id = id;
    }
}
