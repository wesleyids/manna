package com.manager.domain.task;

import com.manager.domain.project.ProjectId;
import javassist.NotFoundException;

import java.util.List;

public interface ITaskRepository {

    public void save(Task task);

    public void update(Task task);

    public Task get(TaskId taskId) throws NotFoundException;

    public void remove(TaskId taskId);

    public List<Task> findAll();

    public void moveTaskTo(ProjectId projectId, TaskId taskId);

}
