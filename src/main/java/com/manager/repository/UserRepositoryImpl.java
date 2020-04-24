package com.manager.repository;

import com.manager.domain.user.IUserRepository;
import com.manager.domain.user.User;
import com.manager.domain.user.UserId;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserRepositoryImpl implements IUserRepository {

    @Autowired
    private UserRepository repository;

    @Override
    public void save(User user) {
        Long id = this.repository.nextId();
        user.setId(new UserId(id == null ? 1L : id));
        this.repository.save(user);
    }

    @Override
    public void update(User user) {
        this.repository.save(user);
    }

    @Override
    public User get(UserId userId) throws NotFoundException {
        Optional<User> user = this.repository.findById(userId);
        if (!user.isPresent()) {
            throw new NotFoundException("Not found user");
        }
        return user.get();
    }

    @Override
    public void remove(UserId userId) throws NotFoundException {
        User user = get(userId);
        this.repository.delete(user);
    }

    @Override
    public List<User> findAll() {
        return this.repository.findAll();
    }
}
