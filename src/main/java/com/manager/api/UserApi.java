package com.manager.api;

import com.manager.domain.user.User;
import com.manager.domain.user.UserId;
import com.manager.domain.user.UserService;
import com.manager.domain.user.command.CreateUserCommand;
import com.manager.domain.user.command.UpdateUserCommand;
import com.manager.domain.user.query.UserResponse;

import java.util.List;

public class UserApi {

    private DrivenPort driver;

    public UserApi(DrivenPort driver) {
        this.driver = driver;
    }

    public void of(CreateUserCommand command) {
        UserService service = new UserService(driver);
        service.save(command);
    }


    public void of(UpdateUserCommand command) {
        UserService service = new UserService(driver);
        service.update(command);
    }

    public UserResponse of(UserId userId) {
        UserService service = new UserService(driver);
        return service.get(userId);
    }

    public void of(Long userId) {
        UserService service = new UserService(driver);
        service.remove(new UserId(userId));
    }

    public List<User> of() {
        UserService service = new UserService(driver);
        return service.findAll();
    }
}
