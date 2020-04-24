package com.manager.business;

import com.manager.domain.task.TaskId;
import com.manager.domain.task.command.CreateTaskCommand;
import com.manager.domain.task.command.UpdateTaskCommand;
import com.manager.domain.task.query.ListTaskRequest;
import com.manager.domain.task.query.RemoveTaskRequest;
import com.manager.domain.task.query.TaskQueryResponse;
import com.manager.domain.task.query.TaskResponse;
import com.manager.infrastructure.config.ApiConfig;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskBusiness {

    @Autowired
    private ApiConfig apiConfig;

    public void save(CreateTaskCommand command) {
        apiConfig.taskApi().of(command);
    }

    public void update(UpdateTaskCommand command) {
        apiConfig.taskApi().of(command);
    }

    public TaskQueryResponse find(TaskId taskId) throws NotFoundException {
        return apiConfig.taskApi().of(taskId);
    }

    public void remove(RemoveTaskRequest request) {
        apiConfig.taskApi().of(request);
    }

    public List<TaskResponse> findAll(ListTaskRequest request) {
        return apiConfig.taskApi().of(request);
    }

    public void moveTask() {
        // ao alterar status da task
        // salvar
        // enviar notificacao via socket
    }

}
