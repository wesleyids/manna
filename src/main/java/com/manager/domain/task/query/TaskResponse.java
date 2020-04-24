package com.manager.domain.task.query;

import com.manager.domain.task.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskResponse {

    public TaskResponse(Task task) {
//        this.id = project.getId().get();
//        this.name = project.getName().get();
//        this.description = project.getDescription().get();
//        this.prefix = project.getPrefix();
    }

    public static List<TaskResponse> of(List<Task> tasks) {
        List<TaskResponse> result = new ArrayList<>();
        for (Task task : tasks) {
            result.add(new TaskResponse(task));
        }
        return result;
    }
}
