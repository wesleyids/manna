package com.manager.repository;

import com.manager.domain.project.ProjectId;
import com.manager.domain.task.ITaskRepository;
import com.manager.domain.task.Task;
import com.manager.domain.task.TaskId;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskRepositoryImpl implements ITaskRepository {

    @Autowired
    private TaskRepository repository;

    @Override
    public void save(Task task) {
        Long id = repository.nextId();
        task.setId(new TaskId(id == null ? 1L : id));
        this.repository.save(task);
    }

    @Override
    public void update(Task task) {
        this.repository.save(task);
    }

    @Override
    public Task get(TaskId taskId) throws NotFoundException {
        return null;
    }

    @Override
    public void remove(TaskId taskId) {

    }

    @Override
    public List<Task> findAll() {
        return this.repository.findAll();
    }

    @Override
    public void moveTaskTo(ProjectId projectId, TaskId taskId) {

    }
}
