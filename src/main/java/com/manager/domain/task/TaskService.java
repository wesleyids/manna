package com.manager.domain.task;

import com.manager.api.DrivenPort;
import com.manager.domain.project.ProjectId;
import com.manager.domain.task.command.CreateTaskCommand;
import com.manager.domain.task.command.UpdateTaskCommand;
import com.manager.domain.task.query.ListTaskRequest;
import com.manager.domain.task.query.RemoveTaskRequest;
import com.manager.domain.task.query.TaskQueryResponse;
import com.manager.domain.task.query.TaskResponse;
import javassist.NotFoundException;

import java.util.List;

public class TaskService {

    private DrivenPort drivenPort;

    public TaskService(DrivenPort drivenPort) {
        this.drivenPort = drivenPort;
    }

    public void save(CreateTaskCommand command) {
        try {
            drivenPort.projectRepository().get(new ProjectId(command.getProjectId()));
        } catch (NotFoundException e) {
            e.printStackTrace();
        }

        drivenPort.taskRepository().save(new Task(command));
    }

    public void update(UpdateTaskCommand command) {

    }

    public TaskQueryResponse get(TaskId taskId) {
        return null;
    }


    public void remove(RemoveTaskRequest request) {

    }

    public List<TaskResponse> findAll(ListTaskRequest request) {
        List<Task> tasks = drivenPort.taskRepository().findAll();
        return TaskResponse.of(tasks);
    }
}
