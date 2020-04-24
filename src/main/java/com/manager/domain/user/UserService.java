package com.manager.domain.user;

import com.manager.api.DrivenPort;
import com.manager.domain.user.command.CreateUserCommand;
import com.manager.domain.user.command.UpdateUserCommand;
import com.manager.domain.user.query.UserResponse;
import javassist.NotFoundException;

import java.util.List;

public class UserService {

    private DrivenPort drivenPort;

    public UserService(DrivenPort drivenPort) {
        this.drivenPort = drivenPort;
    }

    public void save(CreateUserCommand command) {
        drivenPort.userRepository().save(new User(command));
    }

    public void update(UpdateUserCommand command) {
        drivenPort.userRepository().update(null);
    }

    public UserResponse get(UserId userId) {
        try {
            User user = drivenPort.userRepository().get(userId);
            return UserResponse.of(user);
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }


    public void remove(UserId request) {

    }

    public List<User> findAll() {
        List<User> users = drivenPort.userRepository().findAll();
        return users;
    }
}
