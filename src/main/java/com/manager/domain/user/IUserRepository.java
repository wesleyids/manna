package com.manager.domain.user;

import javassist.NotFoundException;
import java.util.List;

public interface IUserRepository {

    public void save(User user);

    public void update(User user);

    public User get(UserId userId) throws NotFoundException;

    public void remove(UserId userId) throws NotFoundException;

    public List<User> findAll();
}
