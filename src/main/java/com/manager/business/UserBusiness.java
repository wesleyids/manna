package com.manager.business;

import com.manager.domain.user.User;
import com.manager.domain.user.UserId;
import com.manager.domain.user.command.CreateUserCommand;
import com.manager.domain.user.command.UpdateUserCommand;
import com.manager.domain.user.query.UserResponse;
import com.manager.infrastructure.config.ApiConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserBusiness {

    @Autowired
    private ApiConfig apiConfig;

    public void save(CreateUserCommand command) {
        apiConfig.userApi().of(command);
    }

    public void update(UpdateUserCommand command) {
        apiConfig.userApi().of(command);
    }

    public UserResponse find(UserId userId) {
        return apiConfig.userApi().of(userId);
    }

    public void remove(Long userId) {
        apiConfig.userApi().of(userId);
    }

    public List<User> findAll() {
        return apiConfig.userApi().of();
    }

}
