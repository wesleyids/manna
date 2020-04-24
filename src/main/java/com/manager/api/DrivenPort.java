package com.manager.api;

import com.manager.domain.QueryAdapter;
import com.manager.domain.project.IProjectRepository;
import com.manager.domain.task.ITaskRepository;
import com.manager.domain.user.IUserRepository;

public class DrivenPort {

    private IProjectRepository projectRepository;

    private ITaskRepository taskRepository;

    private IUserRepository userRepository;

    private QueryAdapter queryAdapter;

    public DrivenPort(
            IProjectRepository projectRepository,
            ITaskRepository taskRepository,
            IUserRepository userRepository,
            QueryAdapter queryAdapter
    ) {
        this.projectRepository = projectRepository;
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
        this.queryAdapter = queryAdapter;
    }

    public IProjectRepository projectRepository() {
        return projectRepository;
    }

    public ITaskRepository taskRepository() {
        return taskRepository;
    }

    public IUserRepository userRepository() {
        return userRepository;
    }

    public QueryAdapter queryStack() {
        return queryAdapter;
    }
}
