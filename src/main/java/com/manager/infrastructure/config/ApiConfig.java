package com.manager.infrastructure.config;

import com.manager.api.*;
import com.manager.infrastructure.impl.InMemoryImpl;
import com.manager.repository.ProjectRepositoryImpl;
import com.manager.repository.TaskRepositoryImpl;
import com.manager.repository.UserRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class ApiConfig implements Api {

    private DrivenPort driver;

    @Autowired
    private ProjectRepositoryImpl projectRepository;

    @Autowired
    private TaskRepositoryImpl taskRepository;

    @Autowired
    private UserRepositoryImpl userRepository;

    @Autowired
    private InMemoryImpl inMemory;

    @Bean
    public void start() {
        this.driver = new DrivenPort(
                projectRepository,
                taskRepository,
                userRepository,
                inMemory
        );
    }

    public ProjectApi projectApi() {
        return new ProjectApi(driver);
    }

    public TaskApi taskApi() {
        return new TaskApi(driver);
    }

    public UserApi userApi() {
        return new UserApi(driver);
    }
}
