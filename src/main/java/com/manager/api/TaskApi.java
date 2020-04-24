package com.manager.api;

import com.manager.domain.task.TaskId;
import com.manager.domain.task.TaskService;
import com.manager.domain.task.command.CreateTaskCommand;
import com.manager.domain.task.command.UpdateTaskCommand;
import com.manager.domain.task.query.ListTaskRequest;
import com.manager.domain.task.query.RemoveTaskRequest;
import com.manager.domain.task.query.TaskQueryResponse;
import com.manager.domain.task.query.TaskResponse;

import java.util.List;

public class TaskApi {

    private DrivenPort driver;

    public TaskApi(DrivenPort driver) {
        this.driver = driver;
    }

    public void of(CreateTaskCommand command) {
        TaskService service = new TaskService(driver);
        service.save(command);
    }


    public void of(UpdateTaskCommand command) {
        TaskService service = new TaskService(driver);
        service.update(command);
    }

    public TaskQueryResponse of(TaskId taskId) {
        TaskService service = new TaskService(driver);
        return service.get(taskId);
    }

    public void of(RemoveTaskRequest request) {
        TaskService service = new TaskService(driver);
        service.remove(request);
    }

    public List<TaskResponse> of(ListTaskRequest request) {
        TaskService service = new TaskService(driver);
        return service.findAll(request);
    }
}
